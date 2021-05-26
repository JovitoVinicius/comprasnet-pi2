package com.siasg.comprasnet.ui.fragment.maps

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentMapsBinding

class MapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var binding: FragmentMapsBinding
    private lateinit var map: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        // Recupera a instância do mapa configurado na atividade
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // Solicita a apresentação do mapa em background
        mapFragment.getMapAsync(this)

        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val posicaoIESB = LatLng(-15.834963163926998, -47.91285006006427)
        val pinoIESB = MarkerOptions().position(posicaoIESB).title("IESB Campus Sul")
        map.addMarker(pinoIESB)

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(posicaoIESB, 13f))
    }

}