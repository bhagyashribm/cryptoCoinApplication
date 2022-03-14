package com.example.myapplication.domain.use_case.get_coins


import com.example.myapplication.common.Resource
import com.example.myapplication.data.remote.dto.toCoinDetailsModel
import com.example.myapplication.domain.model.CoinDtails
import com.example.myapplication.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(asset: String ,nonce :String , apikey:String): Flow<Resource<CoinDtails>> = flow {
        try {
            emit(Resource.Loading<CoinDtails>())
            val coin = repository.getTicker(asset , nonce ,  apikey).toCoinDetailsModel()
            emit(Resource.Success<CoinDtails>(coin))
        } catch(e: HttpException) {
            emit(Resource.Error<CoinDtails>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<CoinDtails>("Couldn't reach server. Check your internet connection."))
        }
    }
}