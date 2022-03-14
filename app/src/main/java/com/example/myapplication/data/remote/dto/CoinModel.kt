package com.example.myapplication.data.remote.dto


import com.example.myapplication.domain.model.CoinList
import com.google.gson.annotations.SerializedName


data class CoinModel(

    @SerializedName("result")
    val result: ArrayList<CoinsDataDto>

)

fun CoinModel.toCoinModel(): CoinList {
    return CoinList(
        result = result
    )
}