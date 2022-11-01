/*
 * Copyright 2022 DroidconKE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android254.presentation.sessions.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.domain.models.DataResult
import com.android254.domain.models.ResourceResult
import com.android254.domain.repos.SessionsRepo
import com.android254.presentation.models.SessionPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Error(
    val message: String
)

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class SessionsViewModel @Inject constructor(
    private val sessionsRepo: SessionsRepo
) : ViewModel() {
    private val _sessions: MutableLiveData<List<SessionPresentationModel>> =
        MutableLiveData(listOf())
    private val _error: MutableLiveData<Error> = MutableLiveData(null)
    private val _loading: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _empty: MutableLiveData<Boolean> = MutableLiveData(false)

    var sessions: LiveData<List<SessionPresentationModel>> = _sessions
    var error: LiveData<Error> = _error
    var loading: LiveData<Boolean> = _loading
    var empty: LiveData<Boolean> = _empty

    init {
        viewModelScope.launch {
            sessionsRepo.fetchAndSaveSessions(true).collectLatest { result ->
                when (result) {
                    is ResourceResult.Success -> {
                        result.data.let {
                            _sessions.value = it?.map { sessionDomainModel ->
                                sessionDomainModel.toPresentationModel()
                            }
                        }
                    }

                    is ResourceResult.Error -> {
                        _error.value = Error(result.message.toString())
                    }

                    is ResourceResult.Loading -> {
                        _loading.value = result.isLoading
                    }

                    is ResourceResult.Empty -> {
                        _empty.value = true
                    }

                    else -> Unit
                }
            }
        }
    }
}