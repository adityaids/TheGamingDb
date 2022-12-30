package com.aditya.thegamingdb.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aditya.thegamingdb.R
import com.aditya.thegamingdb.domain.dto.GameResponse
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.primary
import com.aditya.thegamingdb.ui.theme.white

@Composable
fun CardGameComponent(
    modifier: Modifier = Modifier,
    gameResponse: GameResponse
) {
    Column(
        modifier = Modifier
            .size(height = 200.dp, width = 140.dp)
            .background(primary)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(gameResponse.gameImage)
                .crossfade(true)
                .build(),
            contentDescription = null,
            placeholder = painterResource(R.drawable.ic_image_placeholder),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .size(160.dp)
        )
        Text(
            text = gameResponse.name ?: stringResource(id = R.string.app_name),
            maxLines = 2,
            color = white,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
        RatingComponent(
            initialRating = gameResponse.rating,
        )
    }
}