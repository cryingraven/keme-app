package com.alanmr.kemeapp.ui.state

import com.alanmr.kemeapp.model.News
import com.alanmr.kemeapp.model.Promo

data class HomeScreenState(
    val accountId: String="",
    val newsList: ArrayList<News> = arrayListOf(),
    val promoList: ArrayList<Promo> = arrayListOf()
)
