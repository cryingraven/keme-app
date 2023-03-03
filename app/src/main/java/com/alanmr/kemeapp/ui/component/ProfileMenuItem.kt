package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ProfileMenuItem(
    text: String,
    onClick: ()->Unit
){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)
            .clickable { onClick() }
        ) {
            Text(text = text,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(2f)
            )
            Icon(imageVector = Icons.Outlined.ChevronRight,
                tint = MaterialTheme.colors.primary,
                contentDescription = null)
        }
        Divider()
    }
}