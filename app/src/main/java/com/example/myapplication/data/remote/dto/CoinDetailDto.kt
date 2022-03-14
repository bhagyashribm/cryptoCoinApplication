package com.example.myapplication.data.remote.dto


import com.example.myapplication.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName


data class CoinDetailDto(
    @SerializedName("Asset")
    val asset: String,
    @SerializedName("AssetName")
    val assetName: String,
    @SerializedName("Currency")
    val currency: Boolean,
    @SerializedName("CurrencyName")
    val currencyName: String,
    @SerializedName("DepositAddress")
    val depositeAddress: String

)

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        asset = asset,
        assetName = assetName,
        currency = currency,
        currencyName = currencyName,
        depositeAddress = depositeAddress

    )
}