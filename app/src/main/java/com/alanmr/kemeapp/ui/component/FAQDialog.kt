package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.alanmr.kemeapp.R

@Composable
fun FAQDialog(
    onDismissRequest: ()-> Unit
){
    Dialog(onDismissRequest = onDismissRequest, properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)) {
        Card(modifier = Modifier
            .fillMaxWidth(1f),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                DialogHeader(title = "FAQ", onDismissRequest)
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = "What is SOLKEME ?",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = "SOLKEME is a new way of reward points for consumers and brands. Visit: https://solkeme.com for more details",
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Text(text = "Is SOLKEME ready for SOLANA MAINNET ?",
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(text = "SOLKEME currently only accessible in TESTNET",
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}