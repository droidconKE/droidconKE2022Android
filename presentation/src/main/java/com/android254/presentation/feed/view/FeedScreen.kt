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
package com.android254.presentation.feed.view

import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun FeedScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        val context = LocalContext.current

        LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            items(count = 10) {
                FeedComponent(modifier = Modifier.fillMaxWidth()) { itemId ->
                    Toast.makeText(context, "Clicked: $itemId", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Preview(name = "Light Mode", showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun FeedScreenPreview() {
    DroidconKE2022Theme {
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            FeedScreen()
        }
    }
}