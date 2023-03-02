package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.KemeLogo
import com.alanmr.kemeapp.ui.viewmodel.LoginScreenViewModel
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import kotlinx.coroutines.delay


@Composable
fun LoginScreen(
    sender: ActivityResultSender,
    navController: NavHostController,
    viewModel: LoginScreenViewModel = hiltViewModel()
){
    LaunchedEffect(Unit){
        delay(3000)
        navController.navigate("home")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        KemeLogo(
            modifier = Modifier.size(size = 250.dp)
        )
    }
}