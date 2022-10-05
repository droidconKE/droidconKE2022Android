package com.android254.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import com.android254.presentation.home.viewstate.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    val viewState = HomeViewState()
}