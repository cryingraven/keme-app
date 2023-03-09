package com.alanmr.kemeapp.modules.keme

import com.alanmr.kemeapp.model.NewsResponse
import com.alanmr.kemeapp.model.PromoResponse
import retrofit2.Call
import retrofit2.http.GET

interface KemeService {

    @GET("news/all")
    fun getNews(): Call<NewsResponse>

    @GET("promo/all")
    fun getPromo(): Call<PromoResponse>
}