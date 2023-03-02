package com.alanmr.kemeapp.modules

import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(
    ViewModelComponent::class
)
@Module
class SolanaModule {
    @Provides
    fun provideSolanaWalletAdapter(): MobileWalletAdapter{
        return MobileWalletAdapter()
    }
}