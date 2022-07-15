package com.android254.presentation.common.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(var route: String, var icon: ImageVector, var title: String) {
    object Home : Screens("/home", Icons.Default.Android, "Home")
    object Feed : Screens("/feed", Icons.Default.Android, "Feed")
    object Sessions : Screens("/sessions", Icons.Default.Android, "Sessions")
    object About : Screens("/about", Icons.Default.Android, "About")
    object Splash : Screens("/splash", Icons.Default.Android, "Splash")
}

val bottomNavigationDestinations = listOf(
    Screens.Home,
    Screens.Feed,
    Screens.Sessions,
    Screens.About
)