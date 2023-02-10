package com.example.jersan.ui.comienzo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.R
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.jersan.MainActivity
import com.example.jersan.Reservar
import com.example.jersan.databinding.FragmentoComienzoBinding

class ComienzoFragmento : Fragment() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var _binding: FragmentoComienzoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentoComienzoBinding.inflate(inflater, container, false)
        accion()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.btnEntregar.setOnClickListener {
          //  findNavController().navigate(binding.root.gwt)
        //}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun accion(){
        binding.btnEntregar.setOnClickListener {
            val intent = Intent (activity , Reservar::class.java)
            activity?.startActivity(intent)
        }
    }

}