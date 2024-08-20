package com.example.userregistration.ui.screens

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.userregistration.MainActivity.Companion.PREFS_NAME
import com.example.userregistration.MainActivity.Companion.PREF_TOKEN

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var isLoggedIn by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    val savedToken = sharedPreferences.getString(PREF_TOKEN, null)

    if (savedToken.isNullOrEmpty()) {
        RegistrationScreen(modifier = modifier, sharedPreferences) {
            isLoggedIn = true
        }
    } else {
        isLoggedIn = true
    }

    if (isLoggedIn) {
        LoginScreen(modifier = modifier,sharedPreferences)
    }

}