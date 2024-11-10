package com.example.carrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.carrentalapp.app.presentation.intro.splash.SplashScreen
import com.example.carrentalapp.ui.theme.CarRentalAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarRentalAppTheme {
                SplashScreen()
            }
        }
    }
}

