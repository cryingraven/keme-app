package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.MissionCard

@Composable
fun MissionScreen(
    navController: NavHostController
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "Daily Mission", style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(8.dp))
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
        MissionCard()
    }
}