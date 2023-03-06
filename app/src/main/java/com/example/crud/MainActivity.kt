package com.example.crud

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import com.example.crud.models.AlumnosViewModel
import com.example.crud.navegation.AppNavigation

import com.example.crud.ui.theme.CRUDTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<AlumnosViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CRUDTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()

                }
            }
        }
    }
}







