package com.android254.presentation.login.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.android254.presentation.common.theme.DroidconKE2022Theme

/**
 * @author MamboBryan
 * @email mambobryan@gmail.com
 * Created 7/15/22 at 11:18 PM
 */
@Composable
fun LoginScreen() {
    Text(text = "Login Screen")
}

@Preview
@Composable
fun LoginScreenPreview() {
    DroidconKE2022Theme {
        Text(text = "Login Screen")
    }
}