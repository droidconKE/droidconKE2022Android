package com.android254.presentation.common.components

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


data class Screen(val onClickHandler: () -> Unit, val label: String)

@Composable
fun ScreenNavigationFab() {
    val context = LocalContext.current
    var isOpen by remember {
        mutableStateOf(false)
    }

    val screens = arrayListOf<Screen>(
        Screen(onClickHandler = {

        }, "Login Screen")
    )
    Column() {
        if (isOpen) {
            screens.forEach { screen ->
                Surface(onClick = screen.onClickHandler) {
                    Text(text = screen.label + "→")
                }
            }
        }
        ExtendedFloatingActionButton(
            icon = { Icon(Icons.Filled.Navigation, "") },
            text = { Text("View Screens (Dev only)") },
            onClick = { isOpen = !isOpen},
            elevation = FloatingActionButtonDefaults.elevation(8.dp)
        )
    }


}