package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material.icons.outlined.CheckBoxOutlineBlank
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.alanmr.kemeapp.R
import java.util.Date


@Composable
fun MissionCard(
    title: String,
    image: String,
    description: String,
    validUntil: String,
    completed: Boolean,
    reward: Number,
    onClick: ()->Unit
){
    Column(modifier = Modifier.fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .clickable {
                onClick()
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(model = image, contentDescription = null,
                modifier = Modifier
                    .width(75.dp)
                    .padding(5.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .weight(2f)
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = title, style = MaterialTheme.typography.h6)
                Text(text = "valid util: $validUntil", style = MaterialTheme.typography.caption, fontStyle = FontStyle.Italic)
                Text(text = description, style = MaterialTheme.typography.caption)
            }
           Column(
               verticalArrangement= Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally,
               modifier = Modifier.width(50.dp)
           ){
               if(completed){
                   Icon(imageVector = Icons.Outlined.CheckBox, contentDescription = null)
               }else{
                   Icon(imageVector = Icons.Outlined.CheckBoxOutlineBlank, contentDescription = null)
               }
               Text(text = "$reward Point",
                   color = MaterialTheme.colors.primary,
                   modifier = Modifier.fillMaxWidth(),
                   textAlign = TextAlign.Center,
                   fontSize = 10.sp,
                   fontWeight = FontWeight.Bold
               )
           }
        }
    }
}