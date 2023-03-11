package com.alanmr.kemeapp.modules

import com.alanmr.kemeapp.backendURL
import com.alanmr.kemeapp.modules.keme.KemeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(
    ViewModelComponent::class
)
@Module
class HTTPModule {

    @Provides
    fun httpClient(storage: AccountStorage): KemeService{
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .followRedirects(false)
            .followSslRedirects(false)
            .addInterceptor(Interceptor { chain ->
                val request = chain.request()
                val newRequest = Request.Builder()
                    .url(request.url)
                    .header("Content-Type","application/json")
                    .method(request.method, request.body)
                storage.getCurrentAccount()?.let {
                    newRequest.addHeader("Authorization", it.signature)
                }
                chain.proceed(newRequest.build())
            })
            .addNetworkInterceptor(HttpLoggingInterceptor())
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(backendURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KemeService::class.java)
    }
}