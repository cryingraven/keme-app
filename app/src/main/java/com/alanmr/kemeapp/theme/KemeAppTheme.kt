package com.alanmr.kemeapp.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable


@Composable
fun KemeAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = kemeColor,
        kemeTypography,
        content = content
    )
}