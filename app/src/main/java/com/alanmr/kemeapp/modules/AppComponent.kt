package com.alanmr.kemeapp.modules

import android.app.Activity
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SolanModule::class])
interface AppComponent  {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun inject(activity: Activity)
}