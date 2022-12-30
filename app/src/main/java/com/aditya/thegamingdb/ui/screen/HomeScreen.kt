package com.aditya.thegamingdb.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.R
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.component.ErrorComponent
import com.aditya.thegamingdb.ui.component.NewCardGamesComponent
import com.aditya.thegamingdb.ui.component.PopularCardGamesComponent
import com.aditya.thegamingdb.ui.component.SearchComponent
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.background_color
import com.aditya.thegamingdb.ui.theme.white
import com.aditya.thegamingdb.util.Result

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    mainViewModel.popularGameList
        .collectAsState(initial = Result.Loading)
        .value.let { result ->
        when (result) {
            is Result.Loading -> {
                mainViewModel.getPopularGame()
            }
            is Result.Success -> {
                HomeContent(
                    popularGameList = result.data,
                    latestGameList = result.data.sortedBy { it.isLatest },
                    mainViewModel = mainViewModel)
            }
            is Result.Error -> {
                ErrorComponent()
            }
        }
    }
}

@Composable
fun HomeContent(
    popularGameList: List<GameResponse>,
    latestGameList: List<GameResponse>,
    mainViewModel: MainViewModel,
    modifier: Modifier = Modifier,
) {
    val query by mainViewModel.query

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background_color)
    ) {
        SearchComponent(
            query = query,
            onQueryChange = mainViewModel::search
        )
        if (query.isEmpty()){
            PopularGameContent(
                popularGameList = popularGameList,
                mainViewModel = mainViewModel)
            LatestGameContent(latestGameList = latestGameList)
        } else {
            mainViewModel.searchGameList
                .collectAsState(initial = Result.Loading)
                .value.let { result ->
                    when (result) {
                        is Result.Loading -> {
                            mainViewModel.search(query)
                        }
                        is Result.Success -> {
                            SearchGameContent(result.data)
                        }
                        is Result.Error -> {
                            ErrorComponent()
                        }
                    }
                }
        }
    }
}

@Composable
fun PopularGameContent(
    popularGameList: List<GameResponse>,
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel
) {
    Column(
        modifier = Modifier,
    ) {
        HomeSection(
            title = stringResource(id = R.string.popular_games),
            content = { PopularCardGamesComponent(
                gameList = popularGameList,
                mainViewModel = mainViewModel
            )}
        )
    }
}

@Composable
fun LatestGameContent(
    latestGameList: List<GameResponse>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier,
    ) {
        HomeSection(
            title = stringResource(id = R.string.lates_games),
            content = { NewCardGamesComponent(gameList = latestGameList) }
        )
    }
}

@Composable
fun SearchGameContent(
    gameList: List<GameResponse>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier,
    ) {
        HomeSection(
            title = stringResource(id = R.string.search_result),
            content = { NewCardGamesComponent(gameList = gameList) }
        )
    }
}

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier = modifier) {
        SectionText(title = title, modifier)
        content()
    }
}

@Composable
fun SectionText(
    title : String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = white,
        style = MaterialTheme.typography.h5.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    TheGamingDbTheme {

    }
}