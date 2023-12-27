package com.navin.digishop.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun AboutScreen(navController: NavController,parameter : String,hashem : String) {
   Column {

       Text(text = "About Screen Page")
       Text(text = "name is $parameter")
       Text(text = "hashem is $hashem")

       Button(onClick = {

           navController.navigate("setting")

       }) {
           Text(text = "setting")
       }

   }

}