package com.example.ejercicio_7.ui.screens

import android.app.PictureInPictureUiState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
//import com.example.ejercicio_7.viewmodel.ApiUiState

@Composable

fun HomeScreen(
    //apiUiState: ApiUiState,
    apiUiState: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
//    when(apiUiState){
//        is ApiUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
//        is ApiUiState.Success -> ResultScreen(photos = apiUiState.photos, modifier = modifier.fillMaxWidth())
//        is ApiUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
//    }
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