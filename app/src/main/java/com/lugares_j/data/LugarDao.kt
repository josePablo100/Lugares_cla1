package com.lugares_j.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

import com.lugares_j.model.Lugar

class LugarDao {

    //variables usadas para poder generar la estructura en la nube
    private val coleccion1 = "lugaresApp"
    private val usuario = Firebase.auth.currentUser?.email.toString()
    private val coleccion2 = "misLugares"

    //obtiene la conexion a la base de datos
    private var firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
        //las funciones de bajo nivel para hacer un crud
        //create read update delete

    init {
        firestore.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
    }


        suspend fun saveLugar(lugar: Lugar) {
            val documento : DocumentReference

            if (lugar.id.isEmpty()) {
                documento = firestore
                    .collection(coleccion1)
                    .document(usuario)
                    .collection(coleccion2)
                    .document()
                lugar.id = documento.id
            } else {
                documento = firestore
                .collection(coleccion1)
                    .document(usuario)
                    .collection(coleccion2)
                    .document(lugar.id)
            }
          documento.set(lugar)
              .addOnSuccesListener {
                  Log.d("saveLugar","Lugar creado/actualizado")
              }
              .addOnCanceledListener {
                  Log.e("saveLugar", "Lugar No creado/actualizado")
              }

        }





        suspend fun deleteLugar(lugar: Lugar) {
           // se valida si el lugar tiene id para poder borrarlo
            if (lugar.id.isNotEmpty()) {  // si no esta vacio se puede eliminar
                firestore
                    .collection(coleccion1)
                    .document(usuario)
                    .collection(coleccion2)
                    .document(lugar.id)
                    .delete()
                    .addOnSuccesListener {
                        Log.d("deleteLugar","Lugar eliminado")
                    }
                    .addOnCanceledListener {
                        Log.e("deleteLugar", "Lugar No eliminado")
        }


        fun getLugares() : MutableLiveData<List<Lugar>> {

            val listaLugares = MutableLiveData<List<Lugar>>()

            firestore
                .collection(coleccion1)
                .document(usuario)
                .collection(coleccion2)
                .addSnapshotListener { instantanea, e ->
            if (e != null) { // se dio un error... capturando imagen de la base de datos
             return@addSnapshotListener

            }
            // si estamos aca no hubo error
            if(instantanea != null) {
                val lista = ArrayList<Lugar>()

                //se recorre la instantanea docummento por documento
                instantanea.documents.forEach {
                    val = lugar = it.toObject(Lugar::class.java)
                    if (lugar != null) { //si se pudo convertir el documento en un lugar
                        lista.add(lugar) //se agrega el lugar a la lista

                    }
                }

                listaLugares.value = lista

            }

            return listaLugares


    }
}