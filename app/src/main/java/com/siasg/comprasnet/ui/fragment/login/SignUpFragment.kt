package com.siasg.comprasnet.ui.fragment.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.core.Context
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentSignUpBinding
import com.siasg.comprasnet.domain.UserDatabase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var auth: FirebaseAuth
    private var TAG: String = "SignUP"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        auth = Firebase.auth

        return binding.root
    }


    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d(TAG, "createUserWithEmail:success")
                Toast.makeText(context, "Conta criada, faça login", Toast.LENGTH_SHORT).show()
            } else {
                Log.w(TAG, "createUserWithEmail:failure", task.exception)
                Toast.makeText(context, "Houve um erro, não foi possível criar sua conta", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressWarnings
    fun irParaLogin(v: View) {
        val nome: String = binding.TextEditInputName.text.toString().trim()
        val email: String = binding.TextEditInputEmail.text.toString().trim()
        val password1: String = binding.TextEditInputPassword.text.toString().trim()
        val password2: String = binding.TextEditInputPassword2.text.toString().trim()

        if (email.isEmpty() || nome.isEmpty() || password1.isEmpty() || password2.isEmpty())
            Toast.makeText(context, "Alguns dos campos se encontra vazio", Toast.LENGTH_SHORT).show()
        else {
            if (password1 == password2) {
                createAccount(email, password2)
                saveUserDatabase(nome, email)
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
            } else
                Toast.makeText(context, "As senhas não conferem, digite novamente", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveUserDatabase(nome: String, email: String){
        if(nome.isEmpty()){
            binding.TextEditInputName.error = "Por favor, digite seu nome"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("dados")
        val userId = ref.push().key

        val user = UserDatabase(userId.toString(), nome, email)
        ref.child(userId.toString()).setValue(user).addOnCompleteListener{
            Toast.makeText(this.context, "Usuário Salvo com sucesso", Toast.LENGTH_LONG).show()
        }


    }


}