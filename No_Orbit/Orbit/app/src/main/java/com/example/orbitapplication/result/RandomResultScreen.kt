package com.example.orbitapplication.result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import com.example.orbitapplication.main.MainScreenViewModel
import kotlin.random.Random


@Composable
fun RandomResultScreen(
    modifier: Modifier = Modifier,
    viewModel: ResultScreenViewModel = viewModel(),
    navBackStackEntry: NavBackStackEntry
) {
    val maxNumber = navBackStackEntry.arguments?.getInt("maxNumber") ?: 0
    LaunchedEffect(key1 = maxNumber) {
        viewModel.makeRandomNumber(maxNumber)
    }
    val randomNumber by viewModel.randomNumber.observeAsState(initial = 0)

    Column() {
        Text(
            modifier = modifier.fillMaxWidth(),
            text = "Here is a random\nnumber between 0\nand $maxNumber",
            fontSize = 25.sp
        )

        Spacer(modifier = modifier.padding(30.dp))

        Text(
            modifier = modifier.fillMaxWidth(),
            text = "$randomNumber",
            fontSize = 60.sp,
            textAlign = TextAlign.Center
        )
    }
}