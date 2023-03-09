package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun AboutDialog(
    onDismissRequest: ()-> Unit
){
    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
        Card(modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.9f),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                DialogHeader(title = "About", onDismissRequest)
            }
        }
    }
}