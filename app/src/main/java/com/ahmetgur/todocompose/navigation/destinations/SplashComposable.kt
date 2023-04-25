package com.ahmetgur.todocompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.ahmetgur.todocompose.navigation.util.Constants.SPLASH_SCREEN
import com.ahmetgur.todocompose.ui.screens.splash.SplashScreen


fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = SPLASH_SCREEN,
    )
    {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}