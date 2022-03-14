package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

data class CoinsData(
    val asset: String,

    val assetLong: String,

    val minConfirmation: Int,

    val withdrawTxFee: String,

    val systemProtocol: String,


    val isActive: Boolean,


    val infoMessage: String,

    val maintenanceMode: Boolean,


    val MaintenanceMessage: String,


    val formatPrefix: String,


    val formatSufix: String,


    val decimalSeparator: String,


    val thousandSeparator: String,


    val decimalPlaces: Int,


    val currency: String,



    val currencyLong: String,


    val coinType: Boolean
    )
