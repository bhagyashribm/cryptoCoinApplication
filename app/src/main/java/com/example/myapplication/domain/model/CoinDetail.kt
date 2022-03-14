package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName


data class CoinDetail(

    val asset: String,
    val assetName: String,
    val currency: Boolean,
    val currencyName: String,
    val depositeAddress: String

)
