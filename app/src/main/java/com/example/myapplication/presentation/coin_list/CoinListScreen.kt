package com.example.myapplication.presentation.coin_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.myapplication.presentation.Screen
import com.example.myapplication.presentation.coin_detail.CoinDetailViewModel
import com.example.myapplication.presentation.coin_list.components.CoinListItem


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxHeight()) {
                items(coin.result) { coin ->
                    CoinListItem(
                        coin = coin,
                        onItemClick = {
                            navController.navigate(Screen.CoinDetailScreen.route + "/${coin.currency}")
                        }
                    )
                }
                }
            }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}