package com.lugares_j.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lugares_cla1.R

import com.example.lugares_cla1.databinding.FragmentLugarBinding
import com.lugares_j.adapter.LugarAdapter
import com.lugares_j.model.LugarViewModel

class LugarFragment : Fragment() {

    private var _binding: FragmentLugarBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(LugarViewModel::class.java)

        _binding = FragmentLugarBinding.inflate(inflater, container, false)

        binding.addLugarFabButtom.setOnClickListener{
            findNavController().navigate(R.id.action_nav_lugar_to_addLugarFragment)
        }

        val lugarAdapter=LugarAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = lugarAdapter
        reciclador.layoutManager=LinearLayoutManager(requireContext())

        LugarViewModel.getLugares.observe(viewLifecycleOwner){
            lugares -> lugarAdapter.setListaLugares(it)
        }

        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}