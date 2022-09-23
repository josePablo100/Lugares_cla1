package com.example.lugares_cla1


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.lugares_cla1.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
   //DEfinición del objeto para hacer la autenticación
    private lateinit var auth : FirebaseAuth
    private lateinit var binding : ActivityMainBinding


    //Explicar esto de entrada en semana 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btRegister.setOnClickListener { haceRegistro2()}
        binding.btRegister.setOnClickListener { haceLogin() }

        //se llama a la funcion para crear un usuario de Firebase (correo/contraseña)
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) {task ->
                var user: FirebaseUser? =null
                if(task.isSuccessful){
                    Log.d( "autenticando","usuario creado")
                    user = auth.currentUser  //Recupero la info del usuario creado


                }else {
                    Log.d( "autenticando",  "Error creando usuario")
                    val user=null
                }
                actualiza(user)
            }



    }

    private fun haceRegistro2() {
       val email =binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()
        //se llama a la funcion para crear un usuario de Firebase (correo/contraseña)
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) {task ->
                var user: FirebaseUser? =null
                if(task.isSuccessful){
                    Log.d(  "autenticando","usuario creado")
                    user : auth.currentUser  //Recupero la info del usuario creado


                }else {
                    Log.d(: "autenticando",  "Error creando usuario")
                    val user=null
                }
                actualiza(user)
            }








    }





    private fun haceLogin (){
        val email =binding.etEmail.text.toString()
        val clave = binding.etClave.text.toString()
        //se llama a la funcion para crear un usuario de Firebase (correo/contraseña)
        auth.signInWithEmailAndPassword(email,clave)
            .addOnCompleteListener(this) {task ->
                var user: FirebaseUser? =null
                if(task.isSuccessful){
                    Log.d(  "autenticando","usuario creado")
                    user : auth.currentUser  //Recupero la info del usuario creado


                }else {
                    Log.d( "autenticando",  "Error creando usuario")
                    val user=null
                }
                actualiza(user)
            }
    }

}