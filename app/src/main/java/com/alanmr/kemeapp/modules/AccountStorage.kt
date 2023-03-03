package com.alanmr.kemeapp.modules

import com.alanmr.kemeapp.model.Account

interface AccountStorage {
    fun saveAccount(account: Account)
    fun getCurrentAccount(): Account?
    fun isLogin(): Boolean
    fun logout()
}