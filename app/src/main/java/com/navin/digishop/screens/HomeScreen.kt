package com.navin.digishop.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun HomeScreen(navController: NavController) {

    Column {
        Text(text = "HomeScreen Page")

        Button(onClick = {

            val currency = "Rial"

            navController.navigate(route = "about/$currency/hashem zadeh")

        }) {
            Text(text = "About Us")
        }
    }
    

    
}