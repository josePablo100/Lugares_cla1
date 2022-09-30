package com.example.lugares_cla1.ui.lugar

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lugares_cla1.AddLugarViewModel
import com.example.lugares_cla1.R
import com.example.lugares_cla1.databinding.FragmentAddLugarBinding
import com.example.lugares_cla1.databinding.FragmentLugarBinding
import com.lugares_j.model.LugarViewModel

class AddLugarFragment : Fragment() {



    private var _binding: FragmentAddLugarBinding? = null

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

        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)
        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


}