package com.qq.compose101.screen

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun SeedGardenApp() {
    val navController = rememberNavController()

}

@Composable
fun SeedGardenNavHost(navHostController: NavHostController) {
    val activity = (LocalContext.current as Activity)
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {

        }
    }
}