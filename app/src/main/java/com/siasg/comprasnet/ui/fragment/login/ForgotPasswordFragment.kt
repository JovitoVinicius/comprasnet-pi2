package com.siasg.comprasnet.ui.fragment.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentForgotPasswordBinding
import com.siasg.comprasnet.databinding.FragmentLoginBinding

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var auth: FirebaseAuth
    private var TAG: String = "ForgotPassword"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun passwordReset(email: String) {
        Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "Email sent.")
                    Toast.makeText(context, "Um email de recuperação foi enviado a sua caixa de entrada", Toast.LENGTH_SHORT).show()
                }
            }
    }

    @SuppressWarnings
    fun irParaLogin(v: View){
        val email = binding.TextEditEmailAddress.text.toString()
        if (email.isEmpty())
            Toast.makeText(context, "Um dos campos se encontra vazio", Toast.LENGTH_SHORT).show()
        else {
            passwordReset(email)
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_loginFragment)
        }
    }


}