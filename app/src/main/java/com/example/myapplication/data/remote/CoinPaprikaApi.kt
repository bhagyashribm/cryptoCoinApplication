package com.example.myapplication.data.remote


import com.example.myapplication.data.remote.dto.CoinDetailsModel
import com.example.myapplication.data.remote.dto.CoinModel
import retrofit2.http.*

interface CoinPaprikaApi {

    @Headers("apisign: 026077fa49df05536b00baca986efbda5dd366a219936546023fed2fb36fd5870b241b689e8441e581236b4ef1e7f35c6e5992775a14c362a69d6f02d3278d05"
    , "Accept: application/json",
        "User-Agent: Your-App-Name",
        "Cache-Control: max-age=640000"
    )
    @GET("/api/v3/private/getdepositaddress")
    suspend fun getTicker(@Query("asset") asset: String, @Query("nonce") nonce: String, @Query("apikey") coinId: String ): CoinDetailsModel



    @GET("/api/v3/public/getassets")
    suspend fun getCoinList(): CoinModel
}