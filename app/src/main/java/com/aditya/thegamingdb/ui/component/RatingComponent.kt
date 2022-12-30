package com.aditya.thegamingdb.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle
import com.gowtham.ratingbar.StepSize

@Composable
fun RatingComponent(
    modifier: Modifier = Modifier,
    initialRating: Float
) {
    var rating by remember { mutableStateOf(initialRating) }

    RatingBarConfig()
        .activeColor(Color.Yellow)
        .hideInactiveStars(true)
        .inactiveColor(Color.LightGray)
        .stepSize(StepSize.HALF)
        .numStars(5)
        .isIndicator(true)
        .size(8.dp)
        .padding(4.dp)
        .style(RatingBarStyle.HighLighted)

    RatingBar(
        value = rating,
        config = RatingBarConfig()
            .style(RatingBarStyle.HighLighted),
        onValueChange = {
            rating = it
        },
        onRatingChanged = {
            rating = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .size(8.dp)
    )
}