package com.aditya.thegamingdb.ui.component

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme

@Composable
fun PopularCardGamesComponent(
    gameList: List<GameResponse>,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = modifier
    ) {
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.testTag("RewardList")
        ) {
            items(gameList, key = { it.id }) { data ->
                BiggerCardGameComponent(
                    gameResponse = data,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}

@Composable
fun NewCardGamesComponent(
    gameList: List<GameResponse>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.testTag("RewardList")
        ) {
            items(gameList, key = { it.id }) { data ->
                CardGameComponent(gameResponse = data)
            }
        }
    }
}

@Composable
fun SearchResultGamesComponent(
    gameList: List<GameResponse>,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.testTag("RewardList")
        ) {
            items(gameList, key = { it.id }) { data ->
                BiggerCardGameComponent(
                    gameResponse = data,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}

@Preview
@Composable
fun checkListScreen(){
    TheGamingDbTheme {

    }
}