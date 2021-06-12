package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentAltBinding
import com.siasg.comprasnet.viewmodel.ComprasApiViewModel

class AltFragment : Fragment() {

    private lateinit var binding: FragmentAltBinding
    private val viewmodel: ComprasApiViewModel by viewModels()
    val args: AltFragmentArgs by navArgs()
    var filter: Int = 0
    var search: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAltBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    fun requestApi(v: View){
        findNavController().navigate(R.id.action_altFragment_to_resultFragment)
    }

    fun offline(v: View){
        filter = args.filterArg
        search = args.searchArg
        val action = AltFragmentDirections.actionAltFragmentToResultLocalFragment(filter, search)
        findNavController().navigate(action)
    }

}