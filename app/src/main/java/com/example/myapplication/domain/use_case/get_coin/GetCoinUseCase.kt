package com.example.myapplication.domain.use_case.get_coin

import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.dto.toCoinModel
import com.example.myapplication.domain.model.CoinList
import com.example.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<CoinList>> = flow {
        try {
            emit(Resource.Loading<CoinList>())
            val coin = repository.getCoinList().toCoinModel()
            emit(Resource.Success<CoinList>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinList>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinList>("Couldn't reach server. Check your internet connection."))
        }
    }
}