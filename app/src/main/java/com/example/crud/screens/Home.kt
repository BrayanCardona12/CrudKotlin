package com.example.crud.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crud.models.Alumno
import com.example.crud.R
import com.example.crud.models.AlumnosViewModel
import com.example.crud.navegation.AppScreens


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AppAlumnos(navController: NavController, viewModel: AlumnosViewModel) {
    val logo = painterResource(R.drawable.firebaselogo)

    Scaffold(
        topBar = {
            TopAppBar {}
        },
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(32.dp), onClick = { navController.navigate(
                AppScreens.AddScreen.route) }) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Agregar",
                    tint = Color.White
                )

            } // fin del FloatingActionButton
        }, // fin del floatingActionButton
        floatingActionButtonPosition = FabPosition.End
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column() {
                Image(
                    logo, contentDescription = "Alumnos",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 82.dp)
                )
                LazyColumn() {
                    items(viewModel.alumnos.value) { alumno ->
                        Alumno_Card(alumno)
                    } // fin del items
                } // fin de la LazyColumn
            } // fin de la columna
        } // fin del box
    }//fin del Scaffold
} // fin de la funcion


@Composable
fun Alumno_Card(alumno: Alumno) {
    Card(
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Nombre: ${alumno.nombre}", color = Color.DarkGray, fontSize = 16.sp)
            Text(text = "Curso: ${alumno.curso}", color = Color.DarkGray, fontSize = 16.sp)
            Text(text = "Codigo: ${alumno.codigo}", color = Color.DarkGray, fontSize = 16.sp)
        }
    }
}