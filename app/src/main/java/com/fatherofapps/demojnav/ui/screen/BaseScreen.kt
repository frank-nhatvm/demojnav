package com.fatherofapps.demojnav.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(body: @Composable () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().padding(
        horizontal = 16.dp,
        vertical = 24.dp
    ), contentAlignment = Alignment.Center){
        body()
    }
}