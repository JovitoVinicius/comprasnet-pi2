package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.siasg.comprasnet.databinding.FragmentDetailsBinding

class DetailsFragment: Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        binding.tvDetails.text = args.detailArgs

        return binding.root
    }

}
