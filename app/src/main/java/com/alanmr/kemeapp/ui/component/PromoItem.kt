package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PromoItem(
    image: String,
    title: String,
    url: String,
    validUntil: String
){
    Row(modifier = Modifier.fillMaxWidth()
        .padding(top= 5.dp, bottom = 5.dp)
    ) {
        AsyncImage(model = image,
            contentDescription = null,
            modifier = Modifier.width(100.dp)
                .clip(shape = RoundedCornerShape(15.dp)))
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {
            Text(text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.fillMaxWidth()
                    .padding(4.dp))
            Text(text = "Valid Until: ${validUntil}",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.fillMaxWidth()
                    .padding(4.dp),
                fontStyle = FontStyle.Italic
                )
        }
    }
}