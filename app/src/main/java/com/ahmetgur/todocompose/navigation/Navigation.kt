package com.ahmetgur.todocompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.ahmetgur.todocompose.navigation.destinations.listComposable
import com.ahmetgur.todocompose.navigation.destinations.splashComposable
import com.ahmetgur.todocompose.navigation.destinations.taskComposable
import com.ahmetgur.todocompose.navigation.util.Constants.SPLASH_SCREEN
import com.ahmetgur.todocompose.ui.viewmodels.SharedViewModel


@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController) {
        Screens(navController = navController)
    }
    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN,
    ) {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.task,
            sharedViewModel = sharedViewModel

        )
    }
}