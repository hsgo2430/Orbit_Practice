package com.example.orbitapplication.navigator

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.orbitapplication.main.RandomMainScreen
import com.example.orbitapplication.result.RandomResultScreen


@Composable
fun RandomApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.Main.name,
        modifier = modifier
    ){
        composable(route = ScreenRoute.Main.name){
            RandomMainScreen(
                modifier = modifier,
                viewModel = viewModel(),
                nextBtnClicked = {
                    navigateToRandomScreen(navController, it)
                },
            )
        }

        composable(
            route = "${ScreenRoute.Random.name}/{maxNumber}",
            arguments = listOf(
                navArgument("maxNumber") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
            ){
                backStackEntry ->
                    RandomResultScreen(
                        navBackStackEntry = backStackEntry
                    )
        }


    }
}

private fun navigateToRandomScreen(
    navController: NavController,
    maxNumber: Int
) {
    navController.navigate("${ScreenRoute.Random.name}/${maxNumber}")
}