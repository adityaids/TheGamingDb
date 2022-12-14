package com.aditya.thegamingdb.presenter.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aditya.thegamingdb.presenter.app.TheGamingApp
import com.aditya.thegamingdb.ui.screen.SplashScreen
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.background_color
import com.aditya.thegamingdb.util.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TheGamingDbTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = background_color
                ) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.TheGamingApp.route) {
            TheGamingApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TheGamingAppPreview(){
    TheGamingDbTheme {
        TheGamingApp()
    }
}