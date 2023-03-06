package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.iconUri
import com.alanmr.kemeapp.identityName
import com.alanmr.kemeapp.modules.solana.Connected
import com.alanmr.kemeapp.modules.solana.KemeContract
import com.alanmr.kemeapp.modules.solana.NotConnected
import com.alanmr.kemeapp.modules.solana.PersistentConnection
import com.alanmr.kemeapp.solanaUri
import com.alanmr.kemeapp.ui.state.LoginScreenState
import com.portto.solana.web3.PublicKey
import com.portto.solana.web3.programs.MemoProgram
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
    private val persistentConnection: PersistentConnection,
    private val kemeContract: KemeContract
) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    fun state(): StateFlow<LoginScreenState>{
        return _state
    }
    fun checkLogin(){
        val connection = persistentConnection.getWalletConnection()
        if (connection is Connected) {
            _state.update {
                it.copy(
                    isLoading = false,
                    isLogin = connection.signature!="",
                    isConnected = true,
                    accountId = connection.accountLabel
                )
            }
        }
    }
    fun connect(sender: ActivityResultSender, onSuccess: ()-> Unit){
        val conn = persistentConnection.getWalletConnection()
        viewModelScope.launch {
            val result = walletAdapter.transact(sender) {
                when (conn) {
                    is NotConnected -> {
                        val authed = authorize(solanaUri, iconUri, identityName, RpcCluster.Testnet)
                        Connected(
                            PublicKey(authed.publicKey),
                            authed.accountLabel ?: "",
                            authed.authToken,
                            ""
                        )
                    }
                    is Connected -> {
                        val reauthed = reauthorize(solanaUri, iconUri, identityName, conn.authToken)
                        MemoProgram
                        Connected(
                            PublicKey(reauthed.publicKey),
                            reauthed.accountLabel ?: "",
                            reauthed.authToken,
                            ""
                        )
                    }
                }
            }
            when(result){
                is TransactionResult.Success->{
                    val accountResult = result.payload
                    persistentConnection.saveConnection(accountResult.publicKey, accountResult.accountLabel, accountResult.authToken)
                    _state.update {
                        it.copy(
                            isConnected = true,
                        )
                    }
                    onSuccess()
                }
                else -> {

                }
            }
        }
    }

    fun signMessage(sender: ActivityResultSender, onSuccess: ()->Unit){
        viewModelScope.launch {
            kemeContract.requestSignature(sender, onSuccess = onSuccess)
        }
    }
}