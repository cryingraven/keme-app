package com.alanmr.kemeapp.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(
    ActivityComponent::class
)
@Module
abstract class StorageModule {
    @Binds
    abstract fun provideAccountStorage(accountStorageImpl: AccountStorageImpl): AccountStorage
}