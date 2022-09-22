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
package com.android254.presentation.speakers.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class SpeakersScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `should show heading and show speaker details card`() {
        composeTestRule.setContent {
            SpeakersScreen()
        }

        with(composeTestRule) {
            onNodeWithText("Speakers").assertIsDisplayed()
            onNodeWithContentDescription("Back arrow icon").assertIsDisplayed()
            onNodeWithContentDescription("Speakers Headshot").assertIsDisplayed()
            onNodeWithTag("name").assertIsDisplayed()
            onNodeWithTag("bio").assertIsDisplayed()
            onNodeWithText("Session").assertIsDisplayed()
        }
    }
}