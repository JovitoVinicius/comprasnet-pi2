package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentHomeBinding
import com.siasg.comprasnet.databinding.FragmentLoginBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root

    }
}