package com.android254.presentation.common.bottomnav

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android254.presentation.common.navigation.bottomNavigationDestinations
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    BottomAppBar {
        bottomNavigationDestinations.forEach { destination ->
            NavigationBarItem(
                selected = false,
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = destination.title
                    )
                },
                label = { Text(text = destination.title) },
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(destination.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    DroidconKE2022Theme {
        BottomNavigationBar(rememberNavController())
    }
}