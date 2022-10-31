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
package com.android254.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.android254.presentation.about.view.AboutScreen
import com.android254.presentation.feed.view.FeedScreen
import com.android254.presentation.feedback.view.FeedBackScreen
import com.android254.presentation.home.screen.HomeScreen
import com.android254.presentation.sessions.view.SessionsScreen
import com.android254.presentation.speakers.view.SpeakerDetailsScreen
import com.android254.presentation.speakers.view.SpeakersScreen

@Composable
fun Navigation(
    navController: NavHostController,
    upDateBottomBarState: (Boolean) -> Unit,
    onActionClicked: () -> Unit = {},
) {
    NavHost(navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            upDateBottomBarState(true)
            HomeScreen(
                navigateToSpeakers = { navController.navigate(Screens.Speakers.route) },
                navigateToSpeaker = { twitterHandle ->
                    navController.navigate(
                        Screens.SpeakerDetails.route.replace("{twitterHandle}", twitterHandle)
                    )
                },
                navigateToFeedbackScreen = { navController.navigate(Screens.FeedBack.route) },
                navigateToSessionScreen = { navController.navigate(Screens.Sessions.route) },
                onActionClicked = onActionClicked,
                onSessionClicked = {},
            )
        }
        composable(Screens.Sessions.route) {
            upDateBottomBarState(true)
            SessionsScreen()
        }
        composable(Screens.Feed.route) {
            upDateBottomBarState(true)
            FeedScreen(
                navigateToFeedbackScreen = { navController.navigate(Screens.FeedBack.route) }
            )
        }
        composable(Screens.About.route) {
            upDateBottomBarState(true)
            AboutScreen(
                navigateToFeedbackScreen = { navController.navigate(Screens.FeedBack.route) }
            )
        }
        composable(Screens.Speakers.route) {
            upDateBottomBarState(true)
            SpeakersScreen(
                navigateToHomeScreen = { navController.navigateUp() },
                navigateToSpeaker = { twitterHandle ->
                    navController.navigate(Screens.SpeakerDetails.route.replace("{twitterHandle}", twitterHandle))
                }
            )
        }
        composable(Screens.FeedBack.route) {
            upDateBottomBarState(false)
            FeedBackScreen(
                navigateBack = { navController.navigateUp() }
            )
        }

        composable(
            Screens.SpeakerDetails.route,
            arguments = listOf(navArgument("twitterHandle") { type = NavType.StringType })
        ) {
            val twitterHandle = it.arguments?.getString("twitterHandle")
                ?: throw IllegalStateException("Speaker data missing.")
            upDateBottomBarState(false)
            SpeakerDetailsScreen(
                twitterHandle = twitterHandle,
                navigateBack = { navController.navigateUp() }
            )
        }
    }
}