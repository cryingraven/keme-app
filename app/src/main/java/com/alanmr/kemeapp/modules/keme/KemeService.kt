package com.alanmr.kemeapp.modules.keme

import com.alanmr.kemeapp.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface KemeService {

    @GET("news/all")
    fun getNews(): Call<NewsResponse>

    @GET("promo/all")
    fun getPromo(): Call<PromoResponse>

    @GET("mission/{type}")
    fun getMissions(@Path("type") missionType: String): Call<MissionResponse>

    @POST("mission/finish")
    fun finishMission(@Body() mission: FinishMissionRequest): Call<FinishMissionResponse>
}