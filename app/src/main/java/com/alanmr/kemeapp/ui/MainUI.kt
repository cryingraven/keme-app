package com.alanmr.kemeapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alanmr.kemeapp.ui.screen.LoginScreen
import com.alanmr.kemeapp.ui.screen.MainScreen
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender


@Composable
fun MainUI(sender: ActivityResultSender){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login"){
        composable("login"){
            LoginScreen(sender = sender, navController)
        }
        composable("home"){
            MainScreen(navController = navController)
        }
    }
}