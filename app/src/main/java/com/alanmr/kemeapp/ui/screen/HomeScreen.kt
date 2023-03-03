package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.AccountCard
import com.alanmr.kemeapp.ui.viewmodel.HomeScreenViewModel

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
){
   LaunchedEffect(Unit){
       viewModel.loadData()
   }
   Column(modifier = Modifier
       .fillMaxSize()
       .padding(5.dp)
       .verticalScroll(rememberScrollState())) {
        AccountCard(account = viewModel.state().accountId, onTap = {}, onLogout = {
            viewModel.logout {
                navController.navigate("login"){
                    this.popUpTo("login")
                }
            }
        })
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "News", style = MaterialTheme.typography.h6)
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "Promos", style = MaterialTheme.typography.h6)
   }
}