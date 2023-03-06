package com.example.crud.navegation

sealed class AppScreens(val route:String) {
    object Home : AppScreens(route = "AppAlumnos")
    object AddScreen : AppScreens(route = "AddScreen")
}





