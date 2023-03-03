package com.alanmr.kemeapp.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(
    ViewModelComponent::class
)
@Module
class StorageModule {
    @Provides
    fun provideAccountStorage(@ApplicationContext context: Context): AccountStorage{
        return AccountStorageImpl(context)
    }
}