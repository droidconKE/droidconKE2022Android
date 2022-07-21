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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android254.presentation.about.view.AboutScreen
import com.android254.presentation.feed.view.FeedScreen
import com.android254.presentation.home.view.HomeScreen
import com.android254.presentation.auth.view.LoginScreen
import com.android254.presentation.sessions.view.SessionsScreen

@Composable
fun Navigation(
    navController: NavHostController,
    upDateBottomBarState: (Boolean) -> Unit,
    upDataAppBarState: (Boolean) -> Unit
) {
    NavHost(navController, startDestination = Screens.Login.route) {
        composable(Screens.Home.route) {
            upDataAppBarState(true)
            upDateBottomBarState(true)
            HomeScreen()
        }
        composable(Screens.Sessions.route) {
            upDataAppBarState(true)
            upDateBottomBarState(true)
            SessionsScreen()
        }
        composable(Screens.Feed.route) {
            upDataAppBarState(true)
            upDateBottomBarState(true)
            FeedScreen()
        }
        composable(Screens.About.route) {
            upDataAppBarState(true)
            upDateBottomBarState(true)
            AboutScreen()
        }
        composable(Screens.Login.route) {
            upDataAppBarState(false)
            upDateBottomBarState(false)
            LoginScreen(navController = navController)
        }
    }
}