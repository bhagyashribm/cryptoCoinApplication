package com.example.myapplication.presentation.coin_detail

import com.example.myapplication.domain.model.CoinList


data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinList? = null,
    val error: String = ""
)
