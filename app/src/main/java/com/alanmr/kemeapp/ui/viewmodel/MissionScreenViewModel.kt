package com.alanmr.kemeapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.modules.keme.KemeService
import com.alanmr.kemeapp.ui.state.MissionScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltViewModel
class MissionScreenViewModel @Inject constructor(
    private val storage: AccountStorage,
    private val kemeService: KemeService
): ViewModel() {
    private val _state = MutableStateFlow(MissionScreenState())
    fun state(): StateFlow<MissionScreenState>{
        return _state
    }
    fun loadData(){
        viewModelScope.launch {
            storage.getCurrentAccount()?.run {
                _state.update {
                    it.copy(
                        accountId = this.accountId
                    )
                }
            }
            kemeService.getMissions("daily").awaitResponse().run {
                this.body()?.apply {
                    _state.update {
                        it.copy(
                            missionListDaily = this.missions
                        )
                    }
                }
            }
            kemeService.getMissions("weekly").awaitResponse().run {
                this.body()?.apply {
                    _state.update {
                        it.copy(
                            missionListWeekly = this.missions
                        )
                    }
                }
            }
        }
    }

}