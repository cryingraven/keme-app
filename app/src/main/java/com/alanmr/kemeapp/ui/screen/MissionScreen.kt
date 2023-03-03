package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.MissionCard

@Composable
fun MissionScreen(
    navController: NavHostController
){
    Column(modifier = Modifier.fillMaxWidth()) {
        MissionCard()
    }
}