package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alanmr.kemeapp.R

@Composable
fun KemeLogo(
    modifier: Modifier
){
    Column {
        Image(painter = painterResource(id = R.drawable.gold),
            contentDescription = stringResource(id = R.string.logo),
            contentScale = ContentScale.FillWidth,
            modifier = modifier
        )
        Image(painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo),
            contentScale = ContentScale.FillWidth,
            modifier = modifier.height(80.dp)
        )
    }
}