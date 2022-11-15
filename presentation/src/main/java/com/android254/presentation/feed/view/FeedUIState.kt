package com.android254.presentation.feed.view

import com.android254.presentation.models.FeedPresentationModel

sealed interface FeedUIState{
    object Loading: FeedUIState
    data class Error(val message: String) : FeedUIState
    data class Success(val feeds: List<FeedPresentationModel>) : FeedUIState
}