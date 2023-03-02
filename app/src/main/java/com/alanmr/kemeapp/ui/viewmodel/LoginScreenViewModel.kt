package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val walletAdapter: MobileWalletAdapter
) : ViewModel() {
}