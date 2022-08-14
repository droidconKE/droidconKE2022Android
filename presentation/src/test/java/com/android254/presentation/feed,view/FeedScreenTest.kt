package com.android254.presentation.feed

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.feed.view.FeedScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class FeedScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test
    fun `should display feed items`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                FeedScreen()
            }
        }

        composeTestRule.onNodeWithTag("feeds_lazy_column").assertExists()
        composeTestRule.onNodeWithTag("feeds_lazy_column").assertIsDisplayed()
    }

}
