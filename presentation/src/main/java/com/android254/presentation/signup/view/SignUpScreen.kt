package com.android254.presentation.signup.view

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun SignUpScreen(darkTheme: Boolean = isSystemInDarkTheme(), navController: NavHostController) {

}

@Preview
@Composable


fun SignUpScreenPreview() {
    DroidconKE2022Theme {
        SignUpScreen(navController = rememberNavController())
    }
}