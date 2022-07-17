package com.android254.presentation.auth.view

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidConTextField
import com.android254.presentation.common.components.GoogleAuthButton
import com.android254.presentation.common.theme.Montserrat

@Composable
fun LoginScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec,
        rememberTopAppBarScrollState()
    )
    Box() {

        Scaffold(
            topBar = {
                Box {
                    Image(
                        modifier = Modifier
                            .fillMaxWidth(),
                        painter = if (darkTheme) painterResource(R.drawable.ic_topbar_bg_login_dark) else painterResource(
                            R.drawable.ic_topbar_bg_login
                        ),
                        contentDescription = "background_image",
                        contentScale = ContentScale.FillBounds
                    )
                    LargeTopAppBar(
                        title = { Text(stringResource(R.string.sign_in_label)) },
                        navigationIcon = {
                            IconButton(
                                onClick = { /* doSomething() */ },
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_back_arrow),
                                    contentDescription = "Localized description"
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

                /**
                 * colors = ButtonDefaults.buttonColors(
                containerColor = if (darkTheme) Color.Black else MaterialTheme.colorScheme.primary),
                contentColor = if (darkTheme) Color.White else MaterialTheme.colorScheme.primary),
                )
                 */
                GoogleAuthButton(onClick = { /*TODO*/ }, modifier = Modifier.width(200.dp)) {}
                Spacer(modifier = Modifier.height(32.dp))
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(text = " - OR - ")
                }
                Spacer(modifier = Modifier.height(36.dp))
                Column(modifier = Modifier.padding(38.dp)) {
                    DroidConTextField(label = "Email Address")
                    Spacer(modifier = Modifier.height(24.dp))
                    DroidConTextField(label = "Password")
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(7.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (darkTheme) Color.Black else MaterialTheme.colorScheme.primary,
                            contentColor = if (darkTheme) Color.White else MaterialTheme.colorScheme.onPrimary,
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.sign_in_label).uppercase(),
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                            )
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Forgot Password?", style = TextStyle(
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontFamily = Montserrat
                        )
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Don't have an account?",
                    style = TextStyle(fontSize = 14.sp, fontFamily = Montserrat)
                )
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = stringResource(R.string.sign_up_label), style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF6E4D),
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                            fontFamily = Montserrat
                        )
                    )
                }
            }
        }
    }
}