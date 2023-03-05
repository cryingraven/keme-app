package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.MissionCard

@Composable
fun MissionScreen(
    navController: NavHostController
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(state = rememberScrollState())
    ) {
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
    }
}