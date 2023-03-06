package com.example.crud.screens

import android.annotation.SuppressLint
import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.crud.models.Alumno
import com.example.crud.navegation.AppScreens
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar() {} },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(32.dp),
                onClick = { navController.navigate(AppScreens.Home.route) }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Agregar",
                    tint = Color.White
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    var alumnoNombre by remember { mutableStateOf("") }
    var alumnoGrupo by remember { mutableStateOf("") }
    var alumnoCodigo by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = alumnoNombre,
                onValueChange = { alumnoNombre = it },
                label = { Text(text = "Nombre:") })
            Spacer(modifier = Modifier.height(20.dp))


            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = alumnoGrupo,
                onValueChange = { alumnoGrupo = it },
                label = { Text(text = "Grupo:") })
            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = alumnoCodigo,
                onValueChange = { alumnoCodigo = it },
                label = { Text(text = "Codigo:") })
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    val alumno = Alumno(alumnoNombre, alumnoGrupo, alumnoCodigo.toInt())

                    Firebase.firestore.collection("alumnos").add(alumno)

                    navController.navigate(AppScreens.Home.route)

                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Añadir Alumno")
            }

        }
    } // fin del Box

}







