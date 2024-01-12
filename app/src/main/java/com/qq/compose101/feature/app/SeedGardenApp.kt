package com.qq.compose101.feature.app

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qq.compose101.feature.app.Screen
import com.qq.compose101.feature.plants.ui.screen.home.HomeScreen
import com.qq.compose101.feature.plants.ui.screen.seed.SeedDetailScreen

@Composable
fun SeedGardenApp() {
    val navController = rememberNavController()
    SeedGardenNavHost(navHostController = navController)
}

@Composable
fun SeedGardenNavHost(navHostController: NavHostController) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(onPlantClick = { plantView ->
                navHostController.navigate(
                    Screen.PlantDetail.createRoute(plantId = plantView.plantId)
                )
            })
        }

        composable(route = Screen.PlantDetail.route, arguments = Screen.PlantDetail.navArguments) {
            SeedDetailScreen(
                onBackClick = { navHostController.navigateUp() },
                onShareClick = {},
                onGalleryClick = {}
            )
        }
    }
}