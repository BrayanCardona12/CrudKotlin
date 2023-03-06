package com.example.crud.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.crud.models.AlumnosViewModel
import com.example.crud.screens.AddScreen
import com.example.crud.screens.AppAlumnos

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.Home.route) {
        composable(route = AppScreens.Home.route) { AppAlumnos(navController, AlumnosViewModel() )}
        composable(route = AppScreens.AddScreen.route) { AddScreen(navController) }
    }
}