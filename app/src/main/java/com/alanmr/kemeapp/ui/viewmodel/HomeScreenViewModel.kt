package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.modules.solana.PersistentConnection
import com.alanmr.kemeapp.ui.state.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val persistentConnection: PersistentConnection,
    private val storage: AccountStorage
): ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    fun state(): HomeScreenState{
        return _state.value
    }
    fun loadData(){
        storage.getCurrentAccount()?.run {
            _state.update {
                it.copy(
                    accountId = this.accountId
                )
            }
        }
    }
    fun logout(onSuccess: ()->Unit){
        persistentConnection.clearConnection()
        onSuccess()
    }
}