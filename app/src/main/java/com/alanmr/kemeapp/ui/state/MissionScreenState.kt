package com.alanmr.kemeapp.ui.state

import com.alanmr.kemeapp.model.Mission


data class MissionScreenState (
    val accountId: String="",
    val missionList: ArrayList<Mission> = arrayListOf(),
)