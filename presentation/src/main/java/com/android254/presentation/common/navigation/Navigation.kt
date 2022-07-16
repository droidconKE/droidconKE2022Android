package com.android254.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android254.presentation.about.view.AboutScreen
import com.android254.presentation.feed.view.FeedScreen
import com.android254.presentation.home.view.HomeScreen
import com.android254.presentation.login.view.LoginScreen
import com.android254.presentation.sessions.view.SessionsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
        composable(Screens.Sessions.route) {
            SessionsScreen()
        }
        composable(Screens.Feed.route) {
            FeedScreen()
        }
        composable(Screens.About.route) {
            AboutScreen()
        }
        composable(Screens.Login.route) {
            LoginScreen()
        }
    }
}