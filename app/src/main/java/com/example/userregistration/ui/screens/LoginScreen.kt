package com.example.userregistration.ui.screens

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.userregistration.MainActivity.Companion.KEY_LOGIN
import com.example.userregistration.MainActivity.Companion.KEY_PASSWORD
import com.example.userregistration.MainActivity.Companion.PREF_TOKEN

@Composable
fun LoginScreen(modifier: Modifier = Modifier,sharedPreferences: SharedPreferences) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginStatus by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Login") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val storedLogin = sharedPreferences.getString(KEY_LOGIN, "")
            val storedPassword = sharedPreferences.getString(KEY_PASSWORD, "")

            if (login == storedLogin && password == storedPassword){
                val token = sharedPreferences.getString(PREF_TOKEN, null)
                loginStatus = "Login successful! Token is $token"
            }else{
                loginStatus = "Login failed"
            }
        }){
           Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(loginStatus)
    }

}