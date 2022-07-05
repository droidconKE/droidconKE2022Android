package com.android254.droidconKE2022

import androidx.lifecycle.ViewModel
import org.koin.android.annotation.KoinViewModel
import org.koin.core.annotation.Single

@Single
class GetNameImpl : GetName {
    override fun getName() = "Name"
}

interface GetName {
    fun getName(): String
}

@KoinViewModel
class GetNameViewModel(val getName: GetName) : ViewModel() {
    fun getMyName() {
        getName.getName()
    }
}
