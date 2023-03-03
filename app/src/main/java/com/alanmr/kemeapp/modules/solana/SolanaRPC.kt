package com.alanmr.kemeapp.modules.solana

import com.alanmr.kemeapp.tokenContractProgram
import com.portto.solana.web3.Connection
import com.portto.solana.web3.rpc.types.TokenAccountsByOwnerRpcResult
import com.portto.solana.web3.rpc.types.config.Commitment
import com.portto.solana.web3.util.Cluster
import javax.inject.Inject

class SolanaRPC @Inject constructor() {
    private val api by lazy { Connection(Cluster.TESTNET) }
    suspend fun getLatestBlockHash(): String? = api.getLatestBlockhash(Commitment.FINALIZED)

    suspend fun getPointBalance(account: String): TokenAccountsByOwnerRpcResult =  api.getTokenAccountsByOwner(account, Connection.ProgramId(tokenContractProgram), Commitment.FINALIZED)
}