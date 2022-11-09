package com.android254.presentation.sessions.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android254.presentation.R
import com.android254.presentation.common.components.SessionsCard
import com.android254.presentation.common.components.SessionsLoadingSkeleton
import com.android254.presentation.models.SessionPresentationModel
import com.android254.presentation.sessions.view.SessionsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SessionList(
    viewModel: SessionsViewModel = hiltViewModel()
) {
    val sessions: List<SessionPresentationModel> by viewModel.sessions.observeAsState(arrayListOf())
    val loading: Boolean by viewModel.loading.observeAsState(false)
    val empty: Boolean by viewModel.loading.observeAsState(false)

    if (loading) {
        SessionsLoadingSkeleton()
    } else {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            itemsIndexed(sessions) { index, event ->
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                    SessionsCard(session = event, onclick = {})
                    if (index != sessions.size - 1) {
                        Box(
                            Modifier.padding(
                                start = 40.dp,
                                end = 0.dp,
                                top = 10.dp,
                                bottom = 10.dp
                            )
                        ) {
                            Image(
                                painter = painterResource(id = if (index % 2 == 0) R.drawable.ic_green_session_card_spacer else R.drawable.ic_orange_session_card_spacer),
                                contentDescription = "spacer icon"
                            )
                        }
                    }
                }
            }
        }
    }
}