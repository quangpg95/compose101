package com.qq.compose101.feature.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.qq.compose101.feature.app.Screen

@Composable
fun Compose101App() {

}

@Composable
fun Compose101NavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
    }

}