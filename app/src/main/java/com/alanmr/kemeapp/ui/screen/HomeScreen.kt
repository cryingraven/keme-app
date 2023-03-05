package com.alanmr.kemeapp.ui.screen

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.alanmr.kemeapp.ui.component.NewsItem
import com.alanmr.kemeapp.ui.component.PromoItem
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
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "News", style = MaterialTheme.typography.h6)
       Row(modifier = Modifier
           .fillMaxWidth()
           .horizontalScroll(state = rememberScrollState())) {
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
           NewsItem(title = "Lorem Ipsum", image = "https://picsum.photos/200", url = "https://google.com")
       }
       Spacer(modifier = Modifier.size(4.dp))
       Text(text = "Promos", style = MaterialTheme.typography.h6)
       Column(modifier = Modifier.fillMaxWidth()) {
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
            PromoItem(image = "https://picsum.photos/200", title = "Lorem Ipsum Lorem", url = "https://google.coom", validUntil = "01st Jan 2023")
       }
   }
}