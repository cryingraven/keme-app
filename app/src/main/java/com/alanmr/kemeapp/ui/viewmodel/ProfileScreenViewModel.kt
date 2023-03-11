package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.modules.solana.PersistentConnection
import com.alanmr.kemeapp.modules.solana.SolanaRPC
import com.alanmr.kemeapp.ui.state.ProfileScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val persistentConnection: PersistentConnection,
    private val storage: AccountStorage,
    private val solanaRPC: SolanaRPC
): ViewModel() {
    private val _state = MutableStateFlow(ProfileScreenState())
    fun state(): StateFlow<ProfileScreenState>{
        return _state
    }
    fun loadData(){
        viewModelScope.launch {
            storage.getCurrentAccount()?.run {
                val tokenResult = solanaRPC.getPointBalance(this.accountId)
                _state.update {
                    val count = (this.accountId.count().toDouble()/4)
                    val chunk = this.accountId.chunked(count.roundToInt())
                    if(tokenResult.value.size > 0){
                        it.copy(
                            accountId = "${chunk[0]}...${chunk[3]}",
                            balance = tokenResult.value[0].account.data.parsed.info.tokenAmount.uiAmount.toString()
                        )
                    }else{
                        it.copy(
                            accountId = "${chunk[0]}...${chunk[3]}",
                            balance = "0"
                        )
                    }

                }
            }
        }
    }
    fun logout(onSuccess: ()->Unit){
        persistentConnection.clearConnection()
        onSuccess()
    }
}