package com.siasg.comprasnet.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentLoginBinding
import com.siasg.comprasnet.databinding.FragmentOnboardingBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

    fun login(v: View){

    }

    fun forgot(v: View){

    }

    fun signUp(v: View){

    }

}