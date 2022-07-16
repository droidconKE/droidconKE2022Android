package com.android254.presentation.auth.view

import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidConTextField
import com.android254.presentation.common.components.GoogleAuthButton

@Composable
fun LoginScreen() {
    val decayAnimationSpec = rememberSplineBasedDecay<Float>()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        decayAnimationSpec,
        rememberTopAppBarScrollState()
    )
    Box() {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            painter = painterResource(R.drawable.ic_topbar_bg_login),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
        Scaffold(
            topBar = {
                LargeTopAppBar(
                    title = { Text("Sign In") },
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
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary,
                        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(50.dp))
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
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "SIGN IN")
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Forgot Password?", style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
                Text(text = "Don't have an account?")
                Spacer(modifier = Modifier.height(12.dp))
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Sign Up", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFF6E4D)
                        )
                    )
                }
            }
        }
    }
}