package com.siasg.comprasnet.ui.fragment.more

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentLoginBinding
import com.siasg.comprasnet.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        auth = Firebase.auth

        return binding.root
    }

    private fun checarLogin(): Int {
        val currentUser = auth.currentUser
        return if (currentUser != null){
            0
        } else {
            findNavController().navigate(R.id.action_moreFragment_to_loginFragment)
            1
        }
    }

    fun irParaAjuda(v: View){
        findNavController().navigate(R.id.action_moreFragment_to_helpFragment)
    }

}