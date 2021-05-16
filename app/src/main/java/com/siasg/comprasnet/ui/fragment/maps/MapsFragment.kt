package com.siasg.comprasnet.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentLoginBinding
import com.siasg.comprasnet.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        // Inflate the layout for this fragment
        return binding.root
    }

}