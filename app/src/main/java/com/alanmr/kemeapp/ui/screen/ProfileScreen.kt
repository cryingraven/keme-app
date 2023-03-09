package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = "Profile", style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.size(8.dp))
        AccountCard(account = profileSate.value.accountId, balance = profileSate.value.balance, onTap = {}, onLogout = {
            viewModel.logout {
                navController.navigate("login"){
                    this.popUpTo("login"){
                        inclusive=true
                    }
                }
            }
        })
       Column(modifier = Modifier.fillMaxWidth()
           .padding(top = 10.dp)
           .clip(shape = RoundedCornerShape(10.dp))
           .background(Color.White)
       ) {
           ProfileMenuItem(text = "FAQ", onClick = {

           })
           ProfileMenuItem(text = "Term & Conditions", onClick = {

           })
           ProfileMenuItem(text = "About", onClick = {

           })
       }
    }
}