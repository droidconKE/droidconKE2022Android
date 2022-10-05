package com.android254.presentation.home.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.home.components.HomeSpeakerComponent
import com.android254.presentation.home.components.HomeSpeakersSection
import com.android254.presentation.models.Speaker
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class HomeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `Test home title is displayed`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithTag("home_header").assertIsDisplayed()
    }

    @Test
    fun `Test speakers view is displayed`(){
        composeTestRule.setContent {
            HomeSpeakersSection(speakers = emptyList())
        }

        composeTestRule.onNodeWithTag("speakersLabel").assertIsDisplayed()
        composeTestRule.onNodeWithTag("speakersRaw").assertExists()
        composeTestRule.onNodeWithTag("viewAllBtn").assertExists()


    }
}