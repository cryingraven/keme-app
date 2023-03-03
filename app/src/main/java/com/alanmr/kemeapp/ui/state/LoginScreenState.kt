package com.alanmr.kemeapp.ui.state

data class LoginScreenState(
    var isLoading: Boolean = false,
    var isLogin: Boolean = false,
    var accountId: String = ""
)
