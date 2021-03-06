package com.siasg.comprasnet.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentHomeBinding
import com.siasg.comprasnet.viewmodel.ComprasApiViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewmodel: ComprasApiViewModel by viewModels()
    private lateinit var auth: FirebaseAuth
    var filter: Int = 0
    var search: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onStart() {
        super.onStart()
    }

    fun pesquisar(v: View){
        search = binding.editTextSearch.text.toString().trim()
        val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
        findNavController().navigate(action)
    }

    fun irParaResultTotal(v: View){
        if (checarLogin()==0) {
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaResult30(v: View){
        if (checarLogin()==0) {
            filter = R.color.red_vencem_30dias
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaResult60(v: View){
        if (checarLogin()==0) {
            filter = R.color.orange_vencem_30_60
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaResult90(v: View){
        if (checarLogin()==0) {
            filter = R.color.yellow_vencem_60_90
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaResult180(v: View){
        if (checarLogin()==0) {
            filter = R.color.blue_vencem_90_180
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaResult180mais(v: View){
        if (checarLogin()==0) {
            filter = R.color.blue_vencem_180
            val action = HomeFragmentDirections.actionHomeFragmentToAltFragment(filter, search)
            findNavController().navigate(action)
        }
    }

    fun irParaLogin(){
        findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
    }

    fun checarLogin(): Int {
        auth = Firebase.auth
        val currentUser = auth.currentUser
        return if (currentUser != null){
            0
        } else {
            irParaLogin()
            1
        }
    }
}