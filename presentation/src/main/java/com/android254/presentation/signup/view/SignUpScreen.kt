package com.android254.presentation.signup.view

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidConTextField
import com.android254.presentation.common.components.SocialAuthButton
import com.android254.presentation.common.navigation.Screens
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.common.theme.Montserrat

@Composable
fun SignUpScreen(darkTheme: Boolean = isSystemInDarkTheme(), navController: NavHostController) {
    Text(modifier = Modifier.testTag("heading"), text = "About Screen")
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
                        painterResource(R.drawable.ic_topbar_bg_signup_dark)
                    } else {
                        painterResource(
                            R.drawable.ic_topbar_bg_signup
                        )
                    },
                    contentDescription = stringResource(R.string.login_screen_bg_image_description),
                    contentScale = ContentScale.FillBounds
                )
                LargeTopAppBar(
                    title = { Text(modifier = Modifier.testTag("signup"), text = stringResource(R.string.sign_up_label)) },
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
                .verticalScroll(
                    rememberScrollState())
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            SocialAuthButton(
                onClick = { navController.navigate(Screens.Home.route) },
                modifier = Modifier.width(200.dp)
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
            Spacer(modifier = Modifier.height(32.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = stringResource(R.string.or_label))
            }
            Spacer(modifier = Modifier.height(36.dp))
            Column(modifier = Modifier.padding(38.dp)) {
                DroidConTextField(label = stringResource(R.string.username_field_label))
                Spacer(modifier = Modifier.height(24.dp))
                DroidConTextField(label = stringResource(R.string.email_address_field_label))
                Spacer(modifier = Modifier.height(24.dp))
                DroidConTextField(label = stringResource(R.string.password_field_label))
                Spacer(modifier = Modifier.height(24.dp))
                DroidConTextField(label = stringResource(R.string.confirm_password_field_label))
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { navController.navigate(Screens.Home.route) },
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
                        text = stringResource(R.string.sign_me_up_label).uppercase(),
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = stringResource(R.string.sign_in_prompt_label),
                style = TextStyle(fontSize = 14.sp, fontFamily = Montserrat)
            )
            Spacer(modifier = Modifier.height(12.dp))
            TextButton(onClick = { }) {
                Text(
                    text = stringResource(R.string.sign_in_label),
                    style = TextStyle(
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

@Preview
@Composable

fun SignUpScreenPreview() {
    DroidconKE2022Theme {
        SignUpScreen(navController = rememberNavController())
    }
}