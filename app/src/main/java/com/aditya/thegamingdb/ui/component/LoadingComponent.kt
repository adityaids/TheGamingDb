package com.aditya.thegamingdb.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.fade_color

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(fade_color),
    ) {
        CircularProgressIndicator(
            strokeWidth = 8.dp,
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    TheGamingDbTheme {
        LoadingScreen()
    }
}