package com.android254.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android254.presentation.common.theme.DroidconKE2022Theme
import com.android254.presentation.viewmodel.SessionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DroidconKE2022Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, viewModel: SessionViewModel = hiltViewModel()) {

    Column(Modifier.fillMaxSize()) {

        LazyColumn(Modifier.weight(1f)) {
            items(viewModel.sessionsStream) { item ->
                Text(
                    "${item.publishDate}",
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
        }

        Button(
            onClick = { viewModel.saveRandomSession() },
            Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text("Random Session")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DroidconKE2022Theme {
        Greeting("Android")
    }
}
