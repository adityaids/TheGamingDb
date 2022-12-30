package com.aditya.thegamingdb.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.background_color
import org.koin.java.KoinJavaComponent.inject

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel? = null,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background_color),
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview(){
    TheGamingDbTheme {
        FavoriteScreen()
    }
}