package com.alanmr.kemeapp.modules

import android.content.Context
import android.content.SharedPreferences
import com.alanmr.kemeapp.model.Account
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountStorageImpl constructor(context: Context): AccountStorage {
    private val pref: SharedPreferences = context.getSharedPreferences("Keme", Context.MODE_PRIVATE)
    override fun saveAccount(account: Account) {
        val editor = pref.edit()
        editor.let {
            it.putString("account", Gson().toJson(account))
            it.apply()
        }
    }

    override fun getCurrentAccount(): Account {
        val accountData = pref.getString("account", "{}")
        return Gson().fromJson(accountData, Account::class.java)
    }

    override fun isLogin(): Boolean {
        val account=getCurrentAccount()
        return account.accountId != ""
    }

    override fun logout() {
        val editor = pref.edit()
        editor.let {
            it.putString("account", "{}")
            it.apply()
        }
    }
}