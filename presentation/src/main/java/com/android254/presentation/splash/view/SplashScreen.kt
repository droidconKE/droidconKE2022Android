package com.android254.presentation.splash.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.android254.presentation.common.navigation.Screens
import com.android254.presentation.common.theme.DroidconKE2022Theme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(Screens.Home.route) {
            popUpTo(0)
        }
    }
    DroidconKE2022Theme {
        Text(text = "Splash Screen")
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    DroidconKE2022Theme {
        Text(text = "Splash Screen")
    }
}