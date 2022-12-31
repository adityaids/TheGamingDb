package com.aditya.thegamingdb.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.R
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.component.BiggerCardGameComponent
import com.aditya.thegamingdb.ui.component.ErrorComponent
import com.aditya.thegamingdb.ui.component.FavoriteGamesComponent
import com.aditya.thegamingdb.ui.component.ListContentSection
import com.aditya.thegamingdb.ui.component.PopularCardGamesComponent
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.background_color
import com.aditya.thegamingdb.util.Result
import org.koin.java.KoinJavaComponent.inject

@Composable
fun FavoriteScreen(
    navigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
) {
    mainViewModel.favoriteGameList
        .collectAsState(initial = Result.Loading)
        .value.let { result ->
            when (result) {
                is Result.Loading -> {
                    mainViewModel.getFavoriteGameList()
                }
                is Result.Success -> {
                    FavoriteContent(
                        listGame = result.data,
                        mainViewModel = mainViewModel,
                        navigateToDetail = navigateToDetail
                    )
                }
                is Result.Error -> {
                    ErrorComponent()
                }
            }
        }
}

@Composable
fun FavoriteContent(
    listGame: List<GameResponse>,
    navigateToDetail: (Int) -> Unit,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background_color)
            .padding(16.dp),
    ) {
        ListContentSection(
            title = stringResource(id = R.string.favorite_games),
            content = { FavoriteGamesComponent(
                gameList = listGame,
                mainViewModel = mainViewModel,
                navigateToDetail = navigateToDetail
            )}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoriteScreenPreview(){
    TheGamingDbTheme {

    }
}