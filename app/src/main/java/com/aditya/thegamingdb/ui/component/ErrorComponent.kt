package com.aditya.thegamingdb.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aditya.thegamingdb.R
import com.aditya.thegamingdb.ui.theme.TheGamingDbTheme
import com.aditya.thegamingdb.ui.theme.white

@Composable
fun ErrorComponent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.error_load),
            color = white,
            style = MaterialTheme.typography.subtitle2.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )
    }
}

@Preview
@Composable
fun PreviewError(){
    TheGamingDbTheme {
        ErrorComponent()
    }
}