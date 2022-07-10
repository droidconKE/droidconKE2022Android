package com.android254.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android254.data.dao.SessionDao
import com.android254.data.model.Session
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import javax.inject.Inject

@HiltViewModel
class SessionViewModel @Inject constructor(
    private val sessionDao: SessionDao,
) : ViewModel() {

    fun saveRandomSession() = viewModelScope.launch {
        sessionDao.insert(Session(0, "Welcome Keynote", Clock.System.now()))
    }

}