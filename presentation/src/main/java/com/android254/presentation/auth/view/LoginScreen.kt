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
import androidx.compose.ui.unit.dp
import com.android254.presentation.R
import com.android254.presentation.common.components.DroidConTextField

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
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "SIGN IN WITH GOOGLE")
                }
                Row(horizontalArrangement = Arrangement.Center) {
                    Text(text = " - OR - ")
                }
                Column(modifier = Modifier.padding(38.dp)) {
                    DroidConTextField()
                    Spacer(modifier = Modifier.height(24.dp))
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(7.dp)
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                        Text(text = "SIGN IN")
                    }
                }
            }
        }
    }
}