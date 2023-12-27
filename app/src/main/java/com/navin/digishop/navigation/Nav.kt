package com.navin.digishop.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.navin.digishop.screens.AboutScreen
import com.navin.digishop.screens.HomeScreen
import com.navin.digishop.screens.SettingScreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun Nav() {


    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "home") {

        composable(route = "home") {
            HomeScreen(navController)
        }
        composable(route = "about/{name}/{hashem}",arguments = listOf(navArgument(name = "name"){
            type = NavType.StringType
        },
            navArgument(name = "hashem"){
                type = NavType.StringType
            }
            )) {backStackEntry->

            val hashem : String = backStackEntry.arguments?.getString("hashem")!!
            val name : String = backStackEntry.arguments?.getString("name")!!
               AboutScreen(navController , name , hashem)
        }
        composable(route = "setting") {
            SettingScreen(navController)
        }

    }


}