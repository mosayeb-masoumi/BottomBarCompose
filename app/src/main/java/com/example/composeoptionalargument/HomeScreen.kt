package com.example.composeoptionalargument

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Yellow.copy(alpha = 0.4f)), contentAlignment = Alignment.Center
    ) {


        Button(onClick = {
            navController.navigate(Destination.Chat.route)
        }) {
            Text(text = "go to chat")
        }
        Text(text = "HomeScreen", modifier = Modifier.align(Alignment.TopCenter))
    }

}

