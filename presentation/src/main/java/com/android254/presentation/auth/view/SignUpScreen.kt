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

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidConTextField
import com.android254.presentation.common.components.SocialAuthButton
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.common.theme.Montserrat

@Composable
fun SignUpScreen(goToLogin: () -> Unit = {}, isDarkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(
        topBar = {
            Box {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = if (isDarkTheme) {
                        painterResource(id = R.drawable.toolbar_bg_sign_up_dark)
                    } else {
                        painterResource(id = R.drawable.topbar_bg_sign_up)
                    },
                    contentDescription = stringResource(id = R.string.login_screen_bg_image_description),
                    contentScale = ContentScale.FillBounds
                )
                LargeTopAppBar(
                    title = { Text(stringResource(R.string.sign_up_label)) },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* doSomething() */ },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back_arrow),
                                contentDescription = stringResource(R.string.back_arrow_icon_description)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.largeTopAppBarColors(
                        containerColor = Color.Transparent,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(50.dp))
            SocialAuthButton(
                onClick = {/* doSomething() */ },
                modifier = Modifier.width(200.dp),
                colors =ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.smoke_white),
                    contentColor = Color.Black
                )

            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google_logo_icon),
                    contentDescription = stringResource(R.string.google_icon_description),
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .background(Color.White)
                )
                Text(
                    text = stringResource(R.string.sign_up_with_google_label),
                    modifier = Modifier.padding(start = 10.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.or_label),
                color = colorResource(id = R.color.grey),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier.padding(start = 38.dp, end = 38.dp)
            ) {
                DroidConTextField(label = stringResource(id = R.string.username_field_label))
                Spacer(modifier = Modifier.height(20.dp))
                DroidConTextField(label = stringResource(id = R.string.email_address_field_label))
                Spacer(modifier = Modifier.height(20.dp))
                DroidConTextField(label = stringResource(id = R.string.password_field_label))
                Spacer(modifier = Modifier.height(20.dp))
                DroidConTextField(label = stringResource(id = R.string.confirm_password_label))
                Spacer(modifier = Modifier.height(28.dp))
                Button(
                    onClick = { /* doSomething() */ },
                    modifier = Modifier.fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isDarkTheme) Color.Black else colorResource(id = R.color.blue),
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_me_up_label).uppercase(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = stringResource(R.string.have_account_label),
                style = TextStyle(fontSize = 14.sp, fontFamily = Montserrat)
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextButton(onClick = goToLogin) {
                Text(
                    text = stringResource(R.string.sign_in_label),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.red_orange),
                        fontSize = 16.sp,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = Montserrat
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    DroidconKE2022Theme {
        SignUpScreen()
    }
}