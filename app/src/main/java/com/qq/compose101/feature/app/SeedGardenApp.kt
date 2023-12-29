package com.qq.compose101.feature.app

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qq.compose101.feature.app.Screen

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