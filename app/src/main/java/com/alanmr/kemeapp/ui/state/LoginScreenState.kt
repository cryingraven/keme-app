package com.alanmr.kemeapp.ui.state

data class LoginScreenState(
    var isLoading: Boolean = true,
    var isLogin: Boolean = false,
    var isConnected: Boolean = false,
    var accountId: String = ""
)
