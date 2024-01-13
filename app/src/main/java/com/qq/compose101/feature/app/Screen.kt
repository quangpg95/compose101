package com.qq.compose101.feature.app

import android.util.Log
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String, val navArguments: List<NamedNavArgument> = emptyList()
) {
    companion object {
        const val KEY_PLANT_ID = "PLANT_ID"
    }

    data object Home : Screen("home")

    data object Gallery : Screen(
        route = "gallery/{plantName}", navArguments = listOf(navArgument("plantName") {
            type = NavType.StringType
        })
    ) {
        fun createRoute(plantName: String) = "gallery/$plantName"
    }

    data object PlantDetail : Screen(
        route = "plantDetail/{$KEY_PLANT_ID}", navArguments = listOf(navArgument(KEY_PLANT_ID) {
            type = NavType.StringType
        })
    ) {
        fun createRoute(plantId: String): String {
            Log.d("Create_Route", "createRoute: $plantId-OK")
            return "plantDetail/${plantId}"
        }
    }


}