package com.aditya.thegamingdb.util

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favorite : Screen("favorite")
    object Profile : Screen("profile")
    object GameDetail : Screen("detail")
    object Loading : Screen("loading")
    object SplashScreen : Screen("splashscreen")
    object TheGamingApp : Screen("app")
}