package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.alanmr.kemeapp.R


@Composable
fun MissionCard(){
    Column(modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {

            }) {
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
}