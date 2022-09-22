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
    fun `should show heading and show speaker details card`(){
        composeTestRule.setContent {
            SpeakersScreen()
        }

        with(composeTestRule){
            onNodeWithText("Speakers").assertIsDisplayed()
            onNodeWithContentDescription("Back arrow icon").assertIsDisplayed()
            onNodeWithContentDescription("Speakers Headshot").assertIsDisplayed()
            onNodeWithTag("name").assertIsDisplayed()
            onNodeWithTag("bio").assertIsDisplayed()
            onNodeWithText("Session").assertIsDisplayed()
        }
    }
}