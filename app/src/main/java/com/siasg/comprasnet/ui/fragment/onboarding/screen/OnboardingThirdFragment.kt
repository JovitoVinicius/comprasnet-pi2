package com.siasg.comprasnet.ui.fragment.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentOnboardingFirstBinding
import com.siasg.comprasnet.databinding.FragmentOnboardingThirdBinding

class OnboardingThirdFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

}