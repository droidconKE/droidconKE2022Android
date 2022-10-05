package com.android254.presentation.home.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.home.viewstate.HomeViewState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class HomeBannerSectionTest {
    private val homeViewState = HomeViewState()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `Test home poster is displayed`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                HomeBannerSection(homeViewState)
            }
        }
        composeTestRule.onNodeWithTag("home_event_poster").assertIsDisplayed()
    }

    @Test
    fun `Test home poster is hidden`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                HomeBannerSection(homeViewState.copy(isPosterVisible = false))
            }
        }
        composeTestRule.onNodeWithTag("home_event_poster").assertDoesNotExist()
    }

    @Test
    fun `Test home call for speakers is displayed`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                HomeBannerSection(homeViewState)
            }
        }
        composeTestRule.onNodeWithTag("home_call_for_speakers_link").assertIsDisplayed()
    }

    @Test
    fun `Test home call for speakers is hidden`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                HomeBannerSection(homeViewState.copy(isCallForSpeakersVisible = false))
            }
        }
        composeTestRule.onNodeWithTag("home_call_for_speakers_link").assertDoesNotExist()
    }
}