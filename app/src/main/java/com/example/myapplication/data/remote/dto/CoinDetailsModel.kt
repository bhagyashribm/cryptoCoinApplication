package com.example.myapplication.data.remote.dto


import com.example.myapplication.domain.model.CoinDtails
import com.google.gson.annotations.SerializedName


data class CoinDetailsModel(

    @SerializedName("result")
    val result: CoinDetailDto

)

fun CoinDetailsModel.toCoinDetailsModel(): CoinDtails {
    return CoinDtails(
        result = result
    )
}