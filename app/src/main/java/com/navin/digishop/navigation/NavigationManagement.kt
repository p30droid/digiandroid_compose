package com.navin.digishop.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.navin.digishop.screens.CartScreen
import com.navin.digishop.screens.CategoryScreen
import com.navin.digishop.screens.HomeScreen
import com.navin.digishop.screens.SettingScreen


@Composable
fun NavigationManagement(navController: NavHostController) {

  //  val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationItem.home.route ){

        composable(NavigationItem.home.route) {
            HomeScreen(navController)
        }
        composable(NavigationItem.category.route) {
            CategoryScreen(navController)
        }
        composable(NavigationItem.cart.route) {
            CartScreen(navController)
        }
        composable(NavigationItem.setting.route) {
            SettingScreen(navController)
        }
      }


}