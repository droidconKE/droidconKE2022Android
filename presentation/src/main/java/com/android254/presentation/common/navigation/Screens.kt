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

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(var route: String, var icon: ImageVector, var title: String) {
    object Home : Screens("/home", Icons.Default.Android, "Home")
    object Feed : Screens("/feed", Icons.Default.Android, "Feed")
    object Sessions : Screens("/sessions", Icons.Default.Android, "Sessions")
    object About : Screens("/about", Icons.Default.Android, "About")
    object Login : Screens("/login", Icons.Default.Android, "Login")
    object SignUp: Screens("signUp", Icons.Default.Android, "Sign Up")
}

val bottomNavigationDestinations = listOf(
    Screens.Home,
    Screens.Feed,
    Screens.Sessions,
    Screens.About
)