package com.example.mycityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycityapp.ui.theme.MyCityAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCityAppTheme {
                MyCityApp(modifier = Modifier)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCityApp(modifier = Modifier)
}