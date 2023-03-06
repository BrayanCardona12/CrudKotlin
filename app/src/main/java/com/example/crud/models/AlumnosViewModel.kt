package com.example.crud.models

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase

class AlumnosViewModel: ViewModel() {
    private val _alumnos = mutableStateOf<List<Alumno>>(emptyList())

    val alumnos : State<List<Alumno>>
        get() = _alumnos
    private val query = Firebase.firestore.collection("alumnos")

    init {
        query.addSnapshotListener {
            value, _->
            if(value != null) {
               _alumnos.value = value.toObjects()
        } // fin del if
        } // fin del addSnapshotListener
    } // fin del contructor init
} // fin de la clase

// Funciopn tipo Unit