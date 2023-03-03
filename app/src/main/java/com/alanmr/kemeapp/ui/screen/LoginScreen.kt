package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.KemeLogo
import com.alanmr.kemeapp.ui.component.SolanaLogin
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
        viewModel.checkLogin()
        if(viewModel.state().isLogin){
            navController.navigate("home")
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        KemeLogo(
            modifier = Modifier
                .width(250.dp)
                .height(80.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = stringResource(id = com.alanmr.kemeapp.R.string.tagline),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(5.dp),
            fontStyle = FontStyle.Italic
        )
        Spacer(modifier = Modifier.height(30.dp))
        SolanaLogin(onClick = {
            viewModel.login(sender, onSuccess = {
                navController.navigate("home")
            })
        }, modifier = Modifier
            .width(250.dp)
            .height(50.dp)
        )
    }
}