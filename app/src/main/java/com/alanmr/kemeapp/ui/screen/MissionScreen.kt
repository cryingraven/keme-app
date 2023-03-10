package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.LoadingDialog
import com.alanmr.kemeapp.ui.component.MessageDialog
import com.alanmr.kemeapp.ui.component.MissionCard
import com.alanmr.kemeapp.ui.viewmodel.MissionScreenViewModel
import java.text.SimpleDateFormat

@Composable
fun MissionScreen(
    navController: NavHostController,
    viewModel: MissionScreenViewModel = hiltViewModel()
){

    val missionState = viewModel.state().collectAsState()
    LaunchedEffect(Unit){
        viewModel.loadData()
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .verticalScroll(state = rememberScrollState())
    ) {
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "Mission", style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = "Daily", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.size(4.dp))
        missionState.value.missionListDaily.map {
            val formatedDate = SimpleDateFormat("dd MMM yyyy").format(it.valid_until)
            MissionCard(title = it.title,
                image = it.image,
                description = it.description,
                validUntil = formatedDate,
                reward = it.reward,
                completed = it.completed,
                onClick = {
                    viewModel.finishMission(it)
                }
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "Weekly", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.size(4.dp))
        missionState.value.missionListWeekly.map {
            val formatedDate = SimpleDateFormat("dd MMM yyyy").format(it.valid_until)
            MissionCard(title = it.title,
                image = it.image,
                description = it.description,
                validUntil = formatedDate,
                reward = it.reward,
                completed = it.completed,
                onClick = {
                    viewModel.finishMission(it)
                }
            )
        }

        if(missionState.value.isLoading){
            LoadingDialog(onDismissRequest = {

            })
        }

        if(missionState.value.errorMessage!=""){
            MessageDialog(message = missionState.value.errorMessage, onDismissRequest = {
                viewModel.dismissError()
            })
        }
    }
}