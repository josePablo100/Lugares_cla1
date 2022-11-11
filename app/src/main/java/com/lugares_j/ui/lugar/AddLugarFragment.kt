package com.lugares_j.ui.lugar

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import com.example.lugares_cla1.Manifest
import com.example.lugares_cla1.R
import com.example.lugares_cla1.databinding.FragmentAddLugarBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.lugares_j.model.Lugar
import com.lugares_j.model.LugarViewModel

class AddLugarFragment : Fragment() {


    private lateinit var lugarViewModel: LugarViewModel
    private var _binding: FragmentAddLugarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel =
            ViewModelProvider(this).get(LugarViewModel::class.java)

        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)

        binding.btAdd.setOnClickListener { addLugar() }

        activaGPS()


            return binding.root
        }

        private fun activaGPS() {
          if (requireActivity()
                  .checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)!=
              PackageManager.PERMISSION_GRANTED
                      && requireActivity()
                  .checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)!=
                      PackageManager.PERMISSION_GRANTED)
                   requireActivity()
                     .requestPermissions(
                    arrayOf(Manifest.permission.ACESS_COARSE_LOCATION,
                  Manifest.permission.ACCESS_FINE_LOCATION )

}

    }


        private fun addLugar() {
            val nombre = binding.etNombre.text.toString()
            if (nombre.isNotEmpty()) {


                val correo = binding.etCorreo.text.toString()
                val telefono = binding.etTelefono.text.toString()
                val web = binding.etWeb.text.toString()
                val latitud = binding.tvLatitud.text.toString().toDouble()
                val longitud = binding.tvLongitud.text.toString().toDouble()
                val altura = binding.tvAltura.text.toString().toDouble()
                val lugar = Lugar(
                    "", nombre, correo, telefono, web,
                    0.0, 0.0, 0.0, "", ""
                )

                LugarViewModel.saveLugar(lugar)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.msg_Lugar_added),
                    Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)

            } else {
                val ubicacion: FusedLocationProviderClient =
                    LocationServices.getFusedLocationProviderClient(requireContext())
             ubicacion.lastLocation.addOnSuccessListener {
                 location: Location? ->
                 if (location != null) {
                     binding.tvLatitud.text = "${location.latitud}"
                     binding.tvLongitud.text = "${location.longitud}"
                     binding.tvLAltura.text = "${location.altitude}"

             } else {
                     binding.tvLatitud.text = "0.0"
                     binding.tvLongitud.text = "0.0}"
                     binding.tvLAltura.text = "0.0}"
            }

                Toast.makeText(
                    requireContext(),
                    getString(R.string.msg_data),
                    Toast.LENGTH_LONG
                ).show()


            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




}