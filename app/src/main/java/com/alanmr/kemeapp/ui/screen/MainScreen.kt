package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.EventAvailable
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.viewmodel.MainScreenViewModel
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender


@Composable
fun MainScreen(
    navController: NavHostController,
    sender: ActivityResultSender,
    viewModel: MainScreenViewModel = hiltViewModel()
) {

    LaunchedEffect(true){

    }

    var tabIndex by remember { mutableStateOf(0) }
    val tabsList = listOf("Home", "Missions", "Profile")

    Column(modifier = Modifier.fillMaxSize()
        .background(Color(0xA6FFE0B2))
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)) {
            when(tabIndex){
                0-> HomeScreen(navController = navController)
                1-> MissionScreen(navController = navController)
                2-> ProfileScreen(navController = navController)
            }
        }
        Column(modifier = Modifier.fillMaxWidth()
            .padding(5.dp)
        ) {
            TabRow(selectedTabIndex = tabIndex,
                divider = {},
                indicator = {},
                modifier = Modifier.clip(RoundedCornerShape(50))
            ) {
                tabsList.forEachIndexed { index, title ->
                    Tab(selected = tabIndex == index, onClick = {
                        tabIndex = index
                    }, icon = {
                        when(index){
                            0-> Icon(imageVector = Icons.Outlined.Home, contentDescription = null)
                            1-> Icon(imageVector = Icons.Outlined.EventAvailable, contentDescription = null)
                            2-> Icon(imageVector = Icons.Outlined.AccountCircle, contentDescription = null)
                        }
                    })
                }
            }
        }
    }
}