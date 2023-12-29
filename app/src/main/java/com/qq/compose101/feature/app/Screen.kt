package com.qq.compose101.feature.app

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    data object Home : Screen("home")

    data object Gallery : Screen(
        route = "gallery/{plantName}",
        navArguments = listOf(navArgument("plantName") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(plantName: String) = "gallery/$plantName"
    }

    data object PlantDetail : Screen(
        route = "plantDetail/{plantId}",
        navArguments = listOf(navArgument("plantId") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(plantId: String) = "gallery/$plantId"
    }


}