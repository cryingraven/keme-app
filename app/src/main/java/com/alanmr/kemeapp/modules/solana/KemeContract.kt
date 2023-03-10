package com.alanmr.kemeapp.modules.solana

import android.util.Base64
import android.util.Log
import com.alanmr.kemeapp.iconUri
import com.alanmr.kemeapp.identityName
import com.alanmr.kemeapp.modules.AccountStorage
import com.alanmr.kemeapp.solanaUri
import com.portto.solana.web3.PublicKey
import com.portto.solana.web3.SerializeConfig
import com.portto.solana.web3.Transaction
import com.solana.mobilewalletadapter.clientlib.ActivityResultSender
import com.solana.mobilewalletadapter.clientlib.MobileWalletAdapter
import com.solana.mobilewalletadapter.clientlib.TransactionResult
import com.solana.mobilewalletadapter.clientlib.protocol.MobileWalletAdapterClient
import com.solana.mobilewalletadapter.clientlib.successPayload
import org.bitcoinj.core.Base58
import javax.inject.Inject

class KemeContract @Inject constructor(
    private val walletAdapter: MobileWalletAdapter,
    private val storage: AccountStorage,
    private val solanaRPC: SolanaRPC,
    private val kemeTokenProgam: KemeTokenProgam
) {
    suspend fun sendKemePoint(sender: ActivityResultSender,
                              destination: String,
                              ammount: Long,
                              onSuccess: ()-> Unit,
                              onFailed: () -> Unit
    ){
        storage.getCurrentAccount()?.let {
            val result =walletAdapter.transact(sender){
                val myAccount = PublicKey(it.accountId)
                reauthorize(solanaUri, iconUri, identityName, it.token)
                val blockHash = solanaRPC.getLatestBlockHash()
                val tx = Transaction()
                tx.add(kemeTokenProgam.transfer(
                    myAccount,
                    PublicKey(destination),
                    ammount,
                    myAccount
                ))
                tx.setRecentBlockHash(blockHash!!)
                tx.feePayer = myAccount
                val bytes = tx.serialize(SerializeConfig(requireAllSignatures = false))
                signAndSendTransactions(arrayOf(bytes))
            }
            when(result){
                is TransactionResult.Success ->{
                    onSuccess()
                }
                else->{
                    onFailed()
                }
            }
        }
    }

    suspend fun requestSignature(sender: ActivityResultSender, onSuccess: ()-> Unit){
        storage.getCurrentAccount()?.let {
            val result =walletAdapter.transact(sender){
                val byteArray = PublicKey(it.accountId).toByteArray()
                reauthorize(solanaUri, iconUri, identityName, it.token)
                signMessages(arrayOf(byteArray), arrayOf(byteArray))
            }
            when(result){
                is TransactionResult.Success -> {
                    val signature = Base58.encode(result.payload.signedPayloads[0])
                    val encodedToken = Base64.encodeToString( "${it.accountId}&${signature}".toByteArray(), Base64.NO_WRAP)
                    val newAccount = it.copy(signature = encodedToken)
                    storage.saveAccount(newAccount)
                    onSuccess()
                }
                else->{

                }
            }
        }
    }

}