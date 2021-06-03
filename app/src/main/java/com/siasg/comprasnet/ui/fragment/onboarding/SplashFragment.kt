package com.siasg.comprasnet.ui.fragment.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentSplashBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        auth = Firebase.auth
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val currentUser = auth.currentUser

        GlobalScope.launch(context = Dispatchers.Main) {
            delay(1500)
            if (currentUser != null) {
                startMain()
            } else {
                startOnboarding()
            }
        }

        return binding.root
    }

    private fun startMain() {
        findNavController().navigate(R.id.action_splashFragment_to_mainActivity)
    }

    private fun startOnboarding(){
        findNavController().navigate(R.id.action_splashFragment_to_onboardingFragment)
    }

}