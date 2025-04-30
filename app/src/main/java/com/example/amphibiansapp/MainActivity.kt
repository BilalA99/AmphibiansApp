package com.example.amphibiansapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.amphibiansapp.ui.amphibiansScreenStatic
import com.example.amphibiansapp.ui.theme.AmphibiansAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibiansAppTheme {
                amphibiansScreenStatic() // using static version
            }
        }
    }
}
