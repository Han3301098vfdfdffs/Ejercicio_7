package com.example.ejercicio_7.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio_7.R

@Composable

fun HomeScreen(
    apiUiState: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){

    ResultScreen(photos = apiUiState, modifier = modifier.padding(top = contentPadding.calculateTopPadding()))
}

@Composable

fun LoadingScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center)
    {
        Image(painter = painterResource(id = R.drawable.loader),
            contentDescription =   "Loading")
    }
}
@Composable

fun ResultScreen(photos: String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos)
    }
}

@Composable

fun ErrorScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center)
    {
        Image(painter = painterResource(id = R.drawable.error),
            contentDescription =   "Error")
    }
}
@Preview
@Composable
fun HomeScreenPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ){
        HomeScreen(stringResource(R.string.placeholder_result))
    }
}