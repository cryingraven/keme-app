package com.alanmr.kemeapp.modules

import android.content.Context
import com.alanmr.kemeapp.model.Account
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountStorageImpl @Inject constructor(context: Context): AccountStorage {
    override fun saveAccount(account: Account) {
        TODO("Not yet implemented")
    }

    override fun getCurrentAccount(): Account {
        TODO("Not yet implemented")
    }
}