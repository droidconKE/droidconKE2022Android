package com.android254.presentation.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android254.presentation.about.view.AboutScreen
import com.android254.presentation.feed.view.FeedScreen
import com.android254.presentation.home.view.HomeScreen
import com.android254.presentation.sessions.view.SessionsScreen
import com.android254.presentation.splash.view.SplashScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = Screens.Splash.route) {
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
        composable(Screens.Splash.route) {
            SplashScreen(navController = navController)
        }
    }
}