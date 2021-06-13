package com.siasg.comprasnet.ui.fragment.maps


import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.siasg.comprasnet.R
import com.siasg.comprasnet.databinding.FragmentMapsBinding

class MapsFragment : Fragment(), OnMapReadyCallback {

    private val MAP_REQUEST_TICKET = 9999
    private lateinit var binding: FragmentMapsBinding
    private lateinit var map: GoogleMap
    private lateinit var locationManager: LocationManager



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.lifecycleOwner = this

        locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Recupera a instância do mapa configurado na atividade
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        // Solicita a apresentação do mapa em background
        mapFragment.getMapAsync(this)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onStart() {
        super.onStart()

        checkPermission()
    }

    override fun onPause() {
        super.onPause()

        locationManager.removeUpdates(locationListener)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        val posicaoMAPA = LatLng(-15.798564288427615, -47.87107990369945)
        val pinoMAPA = MarkerOptions().position(posicaoMAPA)
            .title("Ministerio Agricultura, Pecuária e Abastecimento - MAPA")
        map.addMarker(pinoMAPA)

        val posicaoMINC = LatLng(-15.795010500948887, -47.89366823458408)
        val pinoMINC = MarkerOptions().position(posicaoMINC).title("Ministério da Cultura - MINC")
        map.addMarker(pinoMINC)

        val posicaoMC = LatLng(-15.798528565104636, -47.87325844437752)
        val pinoMC = MarkerOptions().position(posicaoMC).title("Ministerio Cidadania - MC")
        map.addMarker(pinoMC)

        val posicaoMCTI = LatLng(-15.799126477557907, -47.86985485787052)
        val pinoMCTI = MarkerOptions().position(posicaoMCTI)
            .title("Ministerio Ciência, Tecnologia e Inovações - MCTI")
        map.addMarker(pinoMCTI)

        val posicaoMCM = LatLng(-15.796911821870287, -47.86735030389867)
        val pinoMCM = MarkerOptions().position(posicaoMCM).title("Ministerio Comunicações - MCM")
        map.addMarker(pinoMCM)

        val posicaoMD = LatLng(-15.796467883110289, -47.86897035819744)
        val pinoMD = MarkerOptions().position(posicaoMD).title("Ministerio Defesa - MD")
        map.addMarker(pinoMD)

        val posicaoMDR = LatLng(-15.797839461421363, -47.878669469642034)
        val pinoMDR =
            MarkerOptions().position(posicaoMDR).title("Ministerio Desenvolvimento Regional - MDR")
        map.addMarker(pinoMDR)

        val posicaoME = LatLng(-15.800646055781922, -47.8691422706774)
        val pinoME = MarkerOptions().position(posicaoME).title("Ministerio Economia - ME")
        map.addMarker(pinoME)

        val posicaoMEC = LatLng(-15.791715621863283, -47.87272197643455)
        val pinoMEC = MarkerOptions().position(posicaoMEC).title("Ministerio Educação - MEC")
        map.addMarker(pinoMEC)

        val posicaoMF = LatLng(-15.80577970223389, -47.88145687321312)
        val pinoMF = MarkerOptions().position(posicaoMF).title("Ministério da Fazenda - MF")
        map.addMarker(pinoMF)

        val posicaoMI = LatLng(-15.79551337973719, -47.8683446185942)
        val pinoMI = MarkerOptions().position(posicaoMI).title("Ministerio Infraestrutura - MI")
        map.addMarker(pinoMI)

        val posicaoMJSP = LatLng(-15.79575974644305, -47.86559804377653)
        val pinoMJSP = MarkerOptions().position(posicaoMJSP)
            .title("Ministerio Justiça e Segurança Pública - MJSP")
        map.addMarker(pinoMJSP)

        val posicaoMMA = LatLng(-15.798418688554124, -47.87243200204892)
        val pinoMMA = MarkerOptions().position(posicaoMMA).title("Ministerio Meio Ambiente - MMA")
        map.addMarker(pinoMMA)

        val posicaoMME = LatLng(-15.795990193761916, -47.86888607608975)
        val pinoMME = MarkerOptions().position(posicaoMME).title("Ministerio Minas e Energia - MME")
        map.addMarker(pinoMME)

        val posicaoMMFDH = LatLng(-15.79779378090323, -47.87305114898633)
        val pinoMMFDH = MarkerOptions().position(posicaoMMFDH)
            .title("Ministerio Mulher, Família e Direitos Humanos - MMFDH")
        map.addMarker(pinoMMFDH)

        val posicaoMRE = LatLng(-15.800756279441597, -47.86753652905487)
        val pinoMRE =
            MarkerOptions().position(posicaoMRE).title("Ministerio Relações Exteriores - MRE")
        map.addMarker(pinoMRE)

        val posicaoMS = LatLng(-15.800023291941814, -47.86826608995761)
        val pinoMS = MarkerOptions().position(posicaoMS).title("Ministerio Saúde - MS")
        map.addMarker(pinoMS)

        val posicaoMT = LatLng(-15.796660485223942, -47.867137313692254)
        val pinoMT = MarkerOptions().position(posicaoMT).title("Ministério dos Transportes - MT")
        map.addMarker(pinoMT)

        val posicaoMTUR = LatLng(-15.796742958013505, -47.868091427185234)
        val pinoMTUR = MarkerOptions().position(posicaoMTUR).title("Ministerio Turismo - MTUR")
        map.addMarker(pinoMTUR)

        val posicaoGGU = LatLng(-15.800557443524507, -47.878320159720325)
        val pinoGGU = MarkerOptions().position(posicaoGGU)
            .title("Controladoria-Geral da União - CGU")
        map.addMarker(pinoGGU)

        val posicaoCN = LatLng(-15.799490998064154, -47.86417119171833)
        val pinoCN = MarkerOptions().position(posicaoCN).title("Congresso Nacional")
        map.addMarker(pinoCN)

        val posicaoSF = LatLng(-15.797560493437798, -47.863409444377716)
        val pinoSF = MarkerOptions().position(posicaoSF).title("Senado Federal")
        map.addMarker(pinoSF)

        val esplanada = LatLng(-15.79687874712141, -47.87007622870773)
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(esplanada, 13f))

    }


    private fun checkPermission(){
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ){
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MAP_REQUEST_TICKET
                )
            }
        }else{
            setupLocation()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == MAP_REQUEST_TICKET) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setupLocation()
            }
        }
    }

    private fun setupLocation() {
        if (context?.let {
                ActivityCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        
        locationManager.requestLocationUpdates(
            LocationManager.GPS_PROVIDER,
            3000,
            1.0f,
            locationListener
        )
    }

    private val locationListener = LocationListener { localicacao ->
        val ponto = LatLng(localicacao.latitude, localicacao.longitude)
        val novoPino = MarkerOptions().position(ponto).title("Sua localização")
        map.addMarker(novoPino)


        val circulo = CircleOptions()
            .center(ponto)
            .radius(200.0)
            .strokeColor(R.color.blue_vencem_90_180)
            .fillColor(R.color.blue_vencem_90_180)

        map.addCircle(circulo)

    }

}



