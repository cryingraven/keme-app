package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun NewsItem(
    title: String,
    image: String,
    url: String
){
    Column(modifier = Modifier.width(150.dp)
        .padding(5.dp)
        .clickable {

        }
    ){
        AsyncImage(model = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .clip(shape = RoundedCornerShape(15.dp)),
            contentScale = ContentScale.FillWidth,
        )
        Text(text= title,
            modifier = Modifier.fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}