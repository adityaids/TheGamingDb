package com.aditya.thegamingdb.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview(){
    TheGamingDbTheme {
        LoadingScreen()
    }
}