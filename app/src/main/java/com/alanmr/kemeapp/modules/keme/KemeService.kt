package com.alanmr.kemeapp.modules.keme

import com.alanmr.kemeapp.model.MissionResponse
import com.alanmr.kemeapp.model.NewsResponse
import com.alanmr.kemeapp.model.PromoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface KemeService {

    @GET("news/all")
    fun getNews(): Call<NewsResponse>

    @GET("promo/all")
    fun getPromo(): Call<PromoResponse>

    @GET("mission/{type}")
    fun getMissions(@Path("type") missionType: String): Call<MissionResponse>
}