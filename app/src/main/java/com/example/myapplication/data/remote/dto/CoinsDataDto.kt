package com.example.myapplication.data.remote.dto


import com.example.myapplication.domain.model.CoinsData
import com.google.gson.annotations.SerializedName


data class CoinsDataDto(

    @SerializedName("Asset")
    val asset: String,
    @SerializedName("AssetLong")
    val assetLong: String,
    @SerializedName("MinConfirmation")
    val minConfirmation: Int,
    @SerializedName("WithdrawTxFee")
    val withdrawTxFee: String,
    @SerializedName("SystemProtocol")
    val systemProtocol: String,

    @SerializedName("IsActive")
    val isActive: Boolean,

    @SerializedName("InfoMessage")
    val infoMessage: String,
    @SerializedName("MaintenanceMode")
    val maintenanceMode: Boolean,

    @SerializedName("MaintenanceMessage")
    val MaintenanceMessage: String,

    @SerializedName("FormatPrefix")
    val formatPrefix: String,

    @SerializedName("FormatSufix")
    val formatSufix: String,

    @SerializedName("DecimalSeparator")
    val decimalSeparator: String,

    @SerializedName("ThousandSeparator")
    val thousandSeparator: String,

    @SerializedName("DecimalPlaces")
    val decimalPlaces: Int,

    @SerializedName("Currency")
    val currency: String,


    @SerializedName("CurrencyLong")
    val currencyLong: String,

    @SerializedName("CoinType")
    val coinType: Boolean,


)



fun CoinsDataDto.toCoin(): CoinsData {
    return CoinsData(
        asset = asset ,
        assetLong = assetLong ,
        minConfirmation = minConfirmation ,
        withdrawTxFee = withdrawTxFee,
        systemProtocol = systemProtocol ,
        isActive = isActive ,
        infoMessage = infoMessage ,
        maintenanceMode = maintenanceMode ,
        MaintenanceMessage = MaintenanceMessage,
        formatPrefix = formatPrefix ,
        formatSufix = formatSufix ,
        decimalSeparator = decimalSeparator ,
        thousandSeparator = thousandSeparator,
        decimalPlaces = decimalPlaces,
        currency = currency,
        currencyLong = currencyLong,
        coinType = coinType
    )
}