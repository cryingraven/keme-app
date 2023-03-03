package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.iconUri
import com.alanmr.kemeapp.identityName
import com.alanmr.kemeapp.modules.solana.Connected
import com.alanmr.kemeapp.modules.solana.NotConnected
import com.alanmr.kemeapp.modules.solana.PersistentConnection
import com.alanmr.kemeapp.solanaUri
import com.alanmr.kemeapp.ui.state.LoginScreenState
import com.portto.solana.web3.PublicKey
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import com.solana.mobilewalletadapter.clientlib.RpcCluster
import com.solana.mobilewalletadapter.clientlib.TransactionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val walletAdapter: MobileWalletAdapter,
    private val persistentConnection: PersistentConnection
) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    fun state(): LoginScreenState{
        return _state.value
    }
    fun checkLogin(){
        val connection = persistentConnection.getWalletConnection()
        if (connection is Connected) {
            _state.update {
                it.copy(
                    isLoading = false,
                    isLogin = true,
                    accountId = connection.accountLabel
                )
            }
        }
    }
    fun login(sender: ActivityResultSender, onSuccess: ()-> Unit){
        val conn = persistentConnection.getWalletConnection()
        viewModelScope.launch {
            val result = walletAdapter.transact(sender) {
                when (conn) {
                    is NotConnected -> {
                        val authed = authorize(solanaUri, iconUri, identityName, RpcCluster.Devnet)
                        Connected(
                            PublicKey(authed.publicKey),
                            authed.accountLabel ?: "",
                            authed.authToken
                        )
                    }
                    is Connected -> {
                        val reauthed = reauthorize(solanaUri, iconUri, identityName, conn.authToken)
                        Connected(
                            PublicKey(reauthed.publicKey),
                            reauthed.accountLabel ?: "",
                            reauthed.authToken
                        )
                    }
                }
            }
            when(result){
                is TransactionResult.Success->{
                    val accountResult = result.payload
                    persistentConnection.saveConnection(accountResult.publicKey, accountResult.accountLabel, accountResult.authToken)
                    onSuccess()
                }
                else -> {

                }
            }
        }
    }
}