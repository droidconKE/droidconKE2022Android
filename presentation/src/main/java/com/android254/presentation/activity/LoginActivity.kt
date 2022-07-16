package com.android254.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.android254.presentation.auth.view.LoginScreen
import com.android254.presentation.common.theme.DroidconKE2022Theme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidconKE2022Theme {
                LoginScreen()
            }
        }
    }
}