package com.siasg.comprasnet.ui.fragment.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentMyAccountBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyAccountFragment : Fragment() {

    private lateinit var binding: FragmentMyAccountBinding
    private lateinit var auth: FirebaseAuth
    private var TAG: String = "My Account"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyAccountBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        auth = Firebase.auth
        getUserData()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val user = auth.currentUser
        if (user == null)
            irParaLogin()
    }

    fun irParaLogin(){
        findNavController().navigate(R.id.action_myAccountFragment_to_loginFragment)
    }

    private fun delUser(){
        val user = Firebase.auth.currentUser!!
        user.delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "User account deleted.")
                }
            }
    }

    private fun getUserData() {
        val user = auth.currentUser
        user.let {
            for (profile in it.providerData) {
                val email = "Email: ${profile.email}"
                binding.tvUserEmail.text = email
                val photoUrl = profile.photoUrl
            }
        }
    }

    @SuppressWarnings
    fun deleteUser(v: View){
        delUser()
        Firebase.auth.signOut()
        irParaLogin()
    }

    @SuppressWarnings
    fun logout (v: View){
        Firebase.auth.signOut()
        irParaLogin()
    }

    @SuppressWarnings
    fun irParaForgot(v: View){
        findNavController().navigate(R.id.action_myAccountFragment_to_forgotPasswordFragment)
    }

}