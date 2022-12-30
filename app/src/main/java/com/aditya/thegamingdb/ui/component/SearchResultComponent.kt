package com.aditya.thegamingdb.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme

@Composable
fun SearchResultComponent(
    gameList: List<GameResponse>,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    Column(modifier = modifier) {
        SearchResultGamesComponent(gameList = gameList, mainViewModel = mainViewModel)
    }
}

@Preview
@Composable
fun PreviewSearchResultComponent(){
    TheGamingDbTheme {

    }
}