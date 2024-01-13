package com.qq.compose101.feature.app

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ShareCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qq.compose101.R
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

        composable(
            route = Screen.PlantDetail.route, arguments = Screen.PlantDetail.navArguments
        ) {
            SeedDetailScreen(onBackClick = { navHostController.navigateUp() },
                onShareClick = {
                    createShareIntent(activity, it)
                },
                onGalleryClick = {

                })
        }
    }
}

private fun createShareIntent(activity: Activity, plantName: String) {
    val shareText = activity.getString(R.string.share_text_plant, plantName)
    val shareIntent = ShareCompat.IntentBuilder(activity).setText(shareText).setType("text/plain")
        .createChooserIntent()
        .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
    activity.startActivity(shareIntent)
}