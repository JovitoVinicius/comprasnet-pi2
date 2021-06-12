package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentResultLocalBinding
import dagger.hilt.android.AndroidEntryPoint
import providesComprasLocal

@AndroidEntryPoint
class ResultLocalFragment : Fragment() {

    private lateinit var binding: FragmentResultLocalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultLocalBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvResultados.layoutManager = LinearLayoutManager(context)
        binding.rvResultados.adapter = providesComprasLocal(requireContext())
    }

    fun irParaDetails(v: View){
        findNavController().navigate(R.id.action_resultFragment_to_detailsFragment)
    }

}