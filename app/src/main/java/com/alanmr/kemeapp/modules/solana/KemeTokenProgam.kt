package com.alanmr.kemeapp.modules.solana

import com.alanmr.kemeapp.tokenContract
import com.portto.solana.web3.AccountMeta
import com.portto.solana.web3.PublicKey
import com.portto.solana.web3.TransactionInstruction
import com.portto.solana.web3.programs.Program
import java.nio.ByteBuffer
import java.nio.ByteOrder
import javax.inject.Inject

class KemeTokenProgam @Inject constructor() : Program() {
    private val PROGRAM_ID = PublicKey(tokenContract)

    fun transfer(
        source: PublicKey,
        destination: PublicKey,
        amount: Long,
        owner: PublicKey
    ): TransactionInstruction {
        val keys: MutableList<AccountMeta> = ArrayList()
        keys.add(AccountMeta(source, false, true))
        keys.add(AccountMeta(destination, false, true))
        keys.add(AccountMeta(owner, true, false))
        val transactionData = encodeTransferTokenInstructionData(
            amount
        )
        return createTransactionInstruction(
            PROGRAM_ID,
            keys,
            transactionData
        )
    }

    private fun encodeTransferTokenInstructionData(amount: Long): ByteArray {
        val result = ByteBuffer.allocate(9)
        result.order(ByteOrder.LITTLE_ENDIAN)
        result.put(3.toByte())
        result.putLong(amount)
        return result.array()
    }

}