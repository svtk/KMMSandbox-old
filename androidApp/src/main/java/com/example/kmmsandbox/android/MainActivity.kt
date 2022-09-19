package com.example.kmmsandbox.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmsandbox.Greeting
import com.example.kmmsandbox.android.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val scope = rememberCoroutineScope()
                    var phrases by remember { mutableStateOf(listOf("Loading")) }
                    LaunchedEffect(true) {
                        scope.launch {
                            phrases = try {
                                Greeting().greeting()
                            } catch (e: Exception) {
                                listOf(e.localizedMessage ?: "error")
                            }
                        }
                    }
                    Greeting(phrases)
                }
            }
        }
    }
}

@Composable
fun Greeting(phrases: List<String>) {
    LazyColumn {
        items(phrases) { phrase ->
            Text(phrase)
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting(listOf("Hello, Android!"))
    }
}
