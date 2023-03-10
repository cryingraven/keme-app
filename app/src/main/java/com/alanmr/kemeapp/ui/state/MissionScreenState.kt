package com.alanmr.kemeapp.ui.state

import com.alanmr.kemeapp.model.Mission


data class MissionScreenState (
    val accountId: String="",
    val missionListDaily: ArrayList<Mission> = arrayListOf(),
    val missionListWeekly: ArrayList<Mission> = arrayListOf(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)