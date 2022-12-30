package com.aditya.thegamingdb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.presenter.viewmodel.MainViewModel
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.primary
import com.aditya.thegamingdb.ui.theme.secondary_background
import com.aditya.thegamingdb.ui.theme.secondary_dark
import com.aditya.thegamingdb.ui.theme.white

@Composable
fun BiggerCardGameComponent(
    modifier: Modifier = Modifier,
    gameResponse: GameResponse,
    mainViewModel: MainViewModel
) {
    var favoritState by remember { mutableStateOf(gameResponse.isFavorite) }
    Box(
        modifier = Modifier
            .background(primary)
            .size(height = 160.dp, width = 240.dp),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(gameResponse.gameImage)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .size(48.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(secondary_background)
        ) {
            Text(
                text = gameResponse.name ?: "no_name",
                maxLines = 2,
                color = white,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            )
            RatingComponent(
                initialRating = gameResponse.rating
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            IconButton(
                modifier = modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 8.dp),
                onClick = {
                    gameResponse.isFavorite = !gameResponse.isFavorite
                    favoritState = gameResponse.isFavorite
                    mainViewModel.setFavorit(gameResponse)
                }) {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    tint = if (!favoritState) white else Color.Red,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PopularCardPreview(){
    TheGamingDbTheme {
    }
}