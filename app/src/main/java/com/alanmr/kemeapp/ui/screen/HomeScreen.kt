package com.alanmr.kemeapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.NewsItem
import com.alanmr.kemeapp.ui.component.PromoItem
import com.alanmr.kemeapp.ui.viewmodel.HomeScreenViewModel
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

@SuppressLint("SimpleDateFormat")
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeScreenViewModel = hiltViewModel()
){
    val homeState = viewModel.state().collectAsState()
   LaunchedEffect(Unit){
       viewModel.loadData()
   }
   Column(modifier = Modifier
       .fillMaxSize()
       .padding(5.dp)
       .verticalScroll(rememberScrollState())) {
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "News", style = MaterialTheme.typography.h6)
       Row(modifier = Modifier
           .fillMaxWidth()
           .horizontalScroll(state = rememberScrollState())) {
           homeState.value.newsList.map {
               NewsItem(title = it.title, image = it.image, url = it.url)
           }
       }
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "Promos", style = MaterialTheme.typography.h6)
       Column(modifier = Modifier.fillMaxWidth()) {
           homeState.value.promoList.map{
               val formatedDate = SimpleDateFormat("dd MMM yyyy").format(it.valid_until)
               PromoItem(image = it.image, title = it.title, url = it.url, validUntil = formatedDate)
           }
       }
   }
}