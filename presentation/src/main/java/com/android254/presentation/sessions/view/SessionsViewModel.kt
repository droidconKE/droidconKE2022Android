package com.android254.presentation.sessions.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android254.domain.repos.SessionsRepo
import com.android254.presentation.models.SessionPresentationModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SessionsViewModel @Inject constructor(
    private val sessionsRepo: SessionsRepo
) : ViewModel() {
    var sessions = MutableLiveData<List<SessionPresentationModel>>(listOf())

    private suspend fun getSessions() {
        val results = sessionsRepo.fetchAndSaveSessions()
        sessions.value = results.data?.map {
            it.toPresentationModel()
        }
    }
}