package com.android254.presentation.login.view

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.android254.presentation.common.theme.DroidconKE2022Theme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@RunWith(RobolectricTestRunner::class)
@Config(instrumentedPackages = ["androidx.loader.content"])
class LoginScreenTest {

    lateinit var navController: NavHostController

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        ShadowLog.stream = System.out
    }

    @Test
    fun `should should show Login Screen and show the heading`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                LoginScreen(navController = navController)
            }
        }

        composeTestRule.onNodeWithTag("heading").assertIsDisplayed()
        composeTestRule.onNodeWithTag("heading").assertTextEquals("Sign In")
    }

    @Test
    fun `should show Google Button`() {
        composeTestRule.setContent {
            DroidconKE2022Theme {
                LoginScreen(navController = navController)
            }
        }

        composeTestRule.onNodeWithTag("google_login_button").assertIsDisplayed()
    }
}