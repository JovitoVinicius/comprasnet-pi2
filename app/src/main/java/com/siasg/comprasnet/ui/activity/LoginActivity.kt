package com.siasg.comprasnet.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.siasg.comprasnet.R
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val operacao = auth.signInWithEmailAndPassword("teste@teste.com", "123456")
        operacao.addOnCompleteListener{resultado ->
            if(resultado.isSuccessful){

            } else{

            }
        }
    }
}