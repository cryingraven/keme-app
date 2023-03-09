package com.alanmr.kemeapp.ui.component

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
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
    val context: Context = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth()
        .padding(top= 5.dp, bottom = 5.dp)
        .clickable {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            context.startActivity(intent)
        }
    ) {
        AsyncImage(model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.width(100.dp)
                .height(100.dp)
                .clip(shape = RoundedCornerShape(15.dp)))
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {
            Text(text = title,
                style = MaterialTheme.typography.h6,
                maxLines = 2,
                modifier = Modifier.fillMaxWidth()
                    .padding(4.dp))
            Text(text = "Valid Until: $validUntil",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.fillMaxWidth()
                    .padding(4.dp),
                fontStyle = FontStyle.Italic
                )

        }
    }
}