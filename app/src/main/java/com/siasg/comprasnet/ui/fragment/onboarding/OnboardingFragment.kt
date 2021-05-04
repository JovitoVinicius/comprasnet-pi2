package com.siasg.comprasnet.ui.fragment.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.siasg.comprasnet.databinding.FragmentOnboardingBinding
import com.siasg.comprasnet.ui.fragment.onboarding.screen.OnboardingFirstFragment
import com.siasg.comprasnet.ui.fragment.onboarding.screen.OnboardingSecondFragment
import com.siasg.comprasnet.ui.fragment.onboarding.screen.OnboardingThirdFragment

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this


        //criar a fonte de dados
        val listaFragmentos = arrayListOf(
            OnboardingFirstFragment(),
            OnboardingSecondFragment(),
            OnboardingThirdFragment()
        )

        // criar o adaptador

        val adaptador = AdaptadorVP(
            listaFragmentos,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.vpOnboarding.adapter = adaptador


        // Inflate the layout for this fragment
        return binding.root
    }

}

class AdaptadorVP(
    val listaFragmentos: List<Fragment>,
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount() = listaFragmentos.size
    override fun createFragment(position: Int) = listaFragmentos[position]
}