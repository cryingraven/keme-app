package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.modules.solana.KemeContract
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val kemeContract: KemeContract,
    private val storage: AccountStorage
    ) : ViewModel(){
    fun singMessage(sender: ActivityResultSender, onFailed: ()->Unit){
        viewModelScope.launch {
            kemeContract.requestSignature(sender, onFailed = {
                storage.logout()
                onFailed()
            })
        }
    }
}