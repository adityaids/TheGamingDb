package com.aditya.thegamingdb.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aditya.thegamingdb.R
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.background_color
import com.aditya.thegamingdb.ui.theme.white
import com.aditya.thegamingdb.util.Screen
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background_color),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(640.dp)
        ) {
            LoadingAnimation(navController = navController)
        }
        Text(
            text = stringResource(id = R.string.description_app),
            color = white,
            textAlign = TextAlign.Center,
            maxLines = 3,
        )
    }
}

@Composable
fun LoadingAnimation(
    navController : NavHostController
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.gaming_animation))
    val logoAnimationState = animateLottieCompositionAsState(composition)
    LottieAnimation(
        composition = composition,
        progress = { logoAnimationState.progress },

        )
    if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
        navController.navigate(Screen.TheGamingApp.route) {
            popUpTo(Screen.SplashScreen.route) {
                inclusive = true
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview(navHostController: NavHostController = rememberNavController()){
    TheGamingDbTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
        }
    }
}