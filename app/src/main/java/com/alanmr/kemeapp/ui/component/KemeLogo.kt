package com.alanmr.kemeapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.alanmr.kemeapp.R

@Composable
fun KemeLogo(
    modifier: Modifier
){
    Image(painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.logo),
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )
}