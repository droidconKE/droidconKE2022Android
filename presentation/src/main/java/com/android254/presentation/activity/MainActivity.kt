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
package com.android254.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.android254.presentation.common.bottomnav.BottomNavigationBar
import com.android254.presentation.common.components.DroidconAppBar
import com.android254.presentation.common.navigation.Navigation
import com.android254.presentation.common.theme.DroidconKE2022Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidconKE2022Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    val appBarState = rememberSaveable() {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { if (appBarState.value) DroidconAppBar() },
        bottomBar = { if (bottomBarState.value) BottomNavigationBar(navController) },
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
        ) {
            Navigation(navController = navController, upDateBottomBarState = {
                bottomBarState.value = it
            }, upDataAppBarState = {
                appBarState.value = it
            })
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}