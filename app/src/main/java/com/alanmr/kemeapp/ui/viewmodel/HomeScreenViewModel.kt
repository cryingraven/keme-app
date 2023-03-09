package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.modules.keme.KemeService
import com.alanmr.kemeapp.modules.solana.PersistentConnection
import com.alanmr.kemeapp.ui.state.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val persistentConnection: PersistentConnection,
    private val storage: AccountStorage,
    private val kemeService: KemeService
): ViewModel() {
    private val _state = MutableStateFlow(HomeScreenState())
    fun state(): StateFlow<HomeScreenState>{
        return _state
    }
    fun loadData(){
        storage.getCurrentAccount()?.run {
            _state.update {
                it.copy(
                    accountId = this.accountId
                )
            }
        }
        viewModelScope.launch {
            kemeService.getNews().awaitResponse().run {
                this.body()?.apply {
                    _state.update {
                        it.copy(
                            newsList = this.news
                        )
                    }
                }
            }
            kemeService.getPromo().awaitResponse().run {
                this.body()?.apply {
                    _state.update {
                        it.copy(
                            promoList = this.promo
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