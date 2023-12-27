package com.navin.digishop.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun SettingScreen(navController: NavController) {
    Column {

        Text(text = "SettingScreen Page")

        Button(onClick = {

            navController.popBackStack()

        }) {
            Text(text = "Back")
        }

        Button(onClick = {

            navController.navigate("home"){
                popUpTo("home"){
                    inclusive=true
                }
            }

        }) {
            Text(text = "Home")
        }




    }
}