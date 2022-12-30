package com.aditya.thegamingdb.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object Profile : Screen("profile")
    object SplashScreen : Screen("splashscreen")
    object TheGamingApp : Screen("app")
}