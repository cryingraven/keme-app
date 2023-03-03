package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.alanmr.kemeapp.R


@Composable
fun MissionCard(){
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(painter = painterResource(id = R.drawable.ticket),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .padding(5.dp)
        )
        Column(
            modifier = Modifier
            .fillMaxWidth()
                .height(100.dp)
            .weight(2f)
            .padding(5.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Mission Title", style = MaterialTheme.typography.h6)
            Text(text = "valid util: ", style = MaterialTheme.typography.caption, fontStyle = FontStyle.Italic)
            Text(text = "Mission Caption", style = MaterialTheme.typography.caption)
        }
    }
}