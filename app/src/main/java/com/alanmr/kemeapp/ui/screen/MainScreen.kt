package com.alanmr.kemeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.EventAvailable
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun MainScreen(
    navController: NavHostController
) {
    var tabIndex by remember { mutableStateOf(0) }
    val tabsList = listOf("Home", "Missions", "Profile")

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().weight(2f)) {
            when(tabIndex){
                0-> HomeScreen(navController = navController)
                1-> MissionScreen(navController = navController)
                2-> ProfileScreen(navController = navController)
            }
        }
        TabRow(selectedTabIndex = tabIndex) {
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