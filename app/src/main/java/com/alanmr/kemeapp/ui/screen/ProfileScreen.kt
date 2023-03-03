package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.AccountCard
import com.alanmr.kemeapp.ui.component.ProfileMenuItem
import com.alanmr.kemeapp.ui.viewmodel.ProfileScreenViewModel
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender


@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileScreenViewModel = hiltViewModel()
){
    LaunchedEffect(true){
        viewModel.loadData()
    }
    val profileSate = viewModel.state().collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
        .verticalScroll(rememberScrollState())) {
        AccountCard(account = profileSate.value.accountId, balance = profileSate.value.balance, onTap = {}, onLogout = {
            viewModel.logout {
                navController.navigate("login"){
                    this.popUpTo("login"){
                        inclusive=true
                    }
                }
            }
        })
        ProfileMenuItem(text = "FAQ", onClick = {

        })
        ProfileMenuItem(text = "Term & Conditions", onClick = {

        })
        ProfileMenuItem(text = "About", onClick = {

        })
    }
}