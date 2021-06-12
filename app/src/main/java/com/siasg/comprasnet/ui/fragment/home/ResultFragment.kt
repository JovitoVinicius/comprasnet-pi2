package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.siasg.comprasnet.databinding.FragmentResultBinding
import com.siasg.comprasnet.ui.adapter.ContratosListAdapter
import com.siasg.comprasnet.viewmodel.ComprasApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val viewmodel: ComprasApiViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvResultados.layoutManager = LinearLayoutManager(context)

        viewmodel.loadData()

        viewmodel.resultado.observe(viewLifecycleOwner) { listaContratos ->
            binding.rvResultados.adapter = ContratosListAdapter(listaContratos)
        }

    }
}