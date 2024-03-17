package com.example.orbitapplication.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orbitapplication.ui.theme.OrbitApplicationTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RandomMainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = viewModel(),
    nextBtnClicked: (Int) -> Unit
    /* viewModel: MainScreenViewModel = MainScreenViewModel()
    * 이렇게 하면 화면이 재구성될때마다 새로은 뷰모델을 불러옴
    * */
) {
    val maxNumber by viewModel.maxNumber.observeAsState(initial = 0)
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$maxNumber",
            fontSize = 60.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.increaseNum() }
        ) {
            Text(text = "UP")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { viewModel.decreaseNum() }
        ) {
            Text(text = "Down")
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { nextBtnClicked(maxNumber) }
        ) {
            Text(text = "Next")
        }
    }
}


@Preview
@Composable
fun printScreen(){
    OrbitApplicationTheme {
        RandomMainScreen(
            modifier = Modifier.fillMaxWidth(),
            nextBtnClicked = {}
        )
    }
}