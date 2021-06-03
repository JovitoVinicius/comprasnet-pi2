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
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth
    private var TAG: String = "Login"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        auth = Firebase.auth
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null)
            irParaConta()
    }

    private fun signIn(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    Toast.makeText(context, "Logou com sucesso", Toast.LENGTH_SHORT).show()
                    var user = auth.currentUser
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(context, "Login falhou", Toast.LENGTH_SHORT).show()
                }
            }
    }

    @SuppressWarnings
    fun login(v: View){
        val email: String = binding.TextEditInputEmailLogin.text.toString()
        val password: String = binding.TextEditInputPasswordLogin.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(context, "Login falhou", Toast.LENGTH_SHORT).show()
        } else {
            signIn(email, password)
        }

        val user = auth.currentUser
        if (user != null) {
            irParaConta()
        }
    }


    fun irParaConta(){
        findNavController().navigate(R.id.action_loginFragment_to_myAccountFragment)
    }

    @SuppressWarnings
    fun irParaForgot(v: View){
        findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
    }
    @SuppressWarnings
    fun irParaSignUp(v: View){
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

}