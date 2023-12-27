package com.navin.digishop.navigation

import com.navin.digishop.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {

    object home : NavigationItem("home", R.drawable.baseline_home_24, "Home")
    object category : NavigationItem("category", R.drawable.baseline_category_24, "Category")
    object cart : NavigationItem("cart", R.drawable.baseline_shopping_cart_24, "Cart")
    object setting : NavigationItem("setting", R.drawable.baseline_settings_24, "Setting")

}