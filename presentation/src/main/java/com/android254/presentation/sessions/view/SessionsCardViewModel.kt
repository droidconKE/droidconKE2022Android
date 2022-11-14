package com.android254.presentation.sessions.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.domain.models.ResourceResult
import com.android254.domain.repos.SessionsRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SessionsCardViewModel @Inject constructor(
    private val sessionsRepo: SessionsRepo
) : ViewModel() {
    fun updateBookmarkStatus(id: String) {
        viewModelScope.launch {
            sessionsRepo.toggleBookmarkStatus(id).collectLatest {
                when (it) {
                    is ResourceResult.Empty -> {}
                    is ResourceResult.Error -> {
                    }
                    is ResourceResult.Loading -> {
                    }
                    is ResourceResult.Success -> {
                    }
                }
            }
        }
    }
}