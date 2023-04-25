package com.ahmetgur.todocompose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.ahmetgur.todocompose.navigation.util.Action
import com.ahmetgur.todocompose.navigation.util.Constants.TASK_ARGUMENT_KEY
import com.ahmetgur.todocompose.navigation.util.Constants.TASK_SCREEN
import com.ahmetgur.todocompose.ui.screens.task.TaskScreen
import com.ahmetgur.todocompose.ui.viewmodels.SharedViewModel

fun NavGraphBuilder.taskComposable(
    sharedViewModel: SharedViewModel, navigateToListScreen: (Action) -> Unit
) {
    composable(
        route = TASK_SCREEN, arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        LaunchedEffect(key1 = taskId){
            sharedViewModel.getSelectedTask(taskId = taskId)
        }
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            if (selectedTask != null || taskId == -1) {
                sharedViewModel.updateTaskFields(selectedTask = selectedTask)
            }
        }

        TaskScreen(
            sharedViewModel = sharedViewModel,
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )


    }
}