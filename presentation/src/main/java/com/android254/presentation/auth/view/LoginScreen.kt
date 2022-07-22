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
package com.android254.presentation.auth.view

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android254.presentation.R
import com.android254.presentation.common.components.SocialAuthButton
import com.android254.presentation.common.navigation.Screens
import com.android254.presentation.common.theme.DroidconKE2022Theme

@Composable
fun LoginScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavHostController, // TODO: Maybe remove this
    goToSignUp: ()->Unit = {}
) {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec,
        rememberTopAppBarScrollState()
    )

    Scaffold(
        topBar = {
            Box {
                Image(
                    modifier = Modifier
                        .fillMaxWidth(),
                    painter = if (darkTheme) {
                        painterResource(R.drawable.ic_topbar_bg_login_dark)
                    } else {
                        painterResource(
                            R.drawable.ic_topbar_bg_login
                        )
                    },
                    contentDescription = stringResource(R.string.login_screen_bg_image_description),
                    contentScale = ContentScale.FillBounds
                )
                LargeTopAppBar(
                    title = { Text(stringResource(R.string.sign_in_label), modifier = Modifier.testTag("heading")) },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* doSomething() */ }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back_arrow),
                                contentDescription = stringResource(R.string.back_arrow_icon_description)
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = if (darkTheme) Color(0xFFF2F0F4) else MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = if (darkTheme) Color(0xFFF2F0F4) else MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            SocialAuthButton(
                onClick = { navController.navigate(Screens.Home.route) },
                modifier = Modifier.width(200.dp).testTag("google_login_button")
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_logo_icon),
                    contentDescription = stringResource(R.string.google_icon_description),
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(MaterialTheme.colorScheme.onPrimary)
                )
                Text(
                    text = stringResource(R.string.sign_in_with_google_label),
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp)
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    DroidconKE2022Theme {
        LoginScreen(navController = rememberNavController())
    }
}