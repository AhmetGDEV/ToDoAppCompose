package com.ahmetgur.todocompose.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.ahmetgur.todocompose.navigation.util.Action
import com.ahmetgur.todocompose.ui.screens.list.ListScreen
import com.ahmetgur.todocompose.ui.viewmodels.SharedViewModel
import com.ahmetgur.todocompose.navigation.util.Constants.LIST_ARGUMENT_KEY
import com.ahmetgur.todocompose.navigation.util.Constants.LIST_SCREEN
import com.ahmetgur.todocompose.navigation.util.toAction

@ExperimentalAnimationApi
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId:Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action){
            sharedViewModel.action.value = action
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}