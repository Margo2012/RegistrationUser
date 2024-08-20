package com.example.userregistration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.userregistration.ui.screens.MainScreen
import com.example.userregistration.ui.theme.UserRegistrationTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val PREFS_NAME = "UserPrefs"
        const val PREF_TOKEN = "token"
        const val KEY_LOGIN = "login"
        const val KEY_PASSWORD = "password"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UserRegistrationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

