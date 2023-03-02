package com.alanmr.kemeapp

import android.app.Application
import com.alanmr.kemeapp.modules.AppComponent
import com.alanmr.kemeapp.modules.DaggerAppComponent

class KemeApp : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext);
    }
    override fun onCreate() {
        super.onCreate()

    }
}