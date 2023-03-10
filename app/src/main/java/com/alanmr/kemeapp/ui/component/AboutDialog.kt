package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.alanmr.kemeapp.R

@Composable
fun AboutDialog(
    onDismissRequest: ()-> Unit
){
    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
        Card(modifier = Modifier
            .fillMaxWidth(1f),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                DialogHeader(title = "About", onDismissRequest)
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = stringResource(id = R.string.app_name),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(text = "Version 1.0.0",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Text(text = "Created By",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic
                )
                Text(text = "alanmr.0110@gmail.com",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}