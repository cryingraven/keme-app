package com.alanmr.kemeapp.modules.solana

import android.util.Base64
import com.alanmr.kemeapp.model.Account
import com.alanmr.kemeapp.modules.AccountStorage
import com.portto.solana.web3.PublicKey
import javax.inject.Inject
sealed class WalletConnection
object NotConnected : WalletConnection()

data class Connected(
    val publicKey: PublicKey,
    val accountLabel: String,
    val authToken: String,
    val signature: String
): WalletConnection()

class PersistentConnection @Inject constructor(
    private val storage: AccountStorage
) {
    private var walletConnection: WalletConnection = NotConnected

    fun getWalletConnection(): WalletConnection {
        return when(walletConnection) {
            is Connected -> walletConnection
            is NotConnected -> {
                val account = storage.getCurrentAccount()
                val newConn = if (!storage.isLogin()) {
                    NotConnected
                } else {
                    Connected(PublicKey(account!!.publicKey), account.accountLabel, account.token, account.signature)
                }
                return newConn
            }
        }
    }

    fun saveConnection(pubKey: PublicKey, accountLabel: String, token: String) {
        storage.saveAccount(Account(
            pubKey.toBase58(),
            accountLabel,
            pubKey.toBase58(),
            token
        ))
        walletConnection = Connected(pubKey, accountLabel, token, "")
    }

    fun clearConnection(){
        storage.logout()
        walletConnection = NotConnected
    }
}