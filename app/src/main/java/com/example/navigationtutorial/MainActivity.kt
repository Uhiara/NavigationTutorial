package com.example.navigationtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigationtutorial.ui.navgraph.NavGraph
import com.example.navigationtutorial.ui.theme.NavigationTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTutorialTheme {
                NavGraph()
            }
        }
    }
}