package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.alanmr.kemeapp.R


@Composable
fun SolanaLogin(
    onClick: () -> Unit,
    modifier: Modifier
){
    Row(modifier = modifier) {
        Button(onClick = onClick,
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier.fillMaxSize()
        ) {
           Row(horizontalArrangement = Arrangement.Start,
               verticalAlignment = Alignment.CenterVertically,
               modifier = Modifier.fillMaxSize()) {
               Image(painter = painterResource(id = R.drawable.sol),
                   contentDescription = stringResource(id = R.string.sol),
                   modifier = Modifier.height(30.dp).padding(2.dp),
                   contentScale = ContentScale.Fit)
               Text(text = stringResource(id = R.string.login), style = MaterialTheme.typography.h6, textAlign = TextAlign.Center, modifier = Modifier.weight(2f))
           }
        }
    }
}