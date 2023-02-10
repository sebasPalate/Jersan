package com.example.jersan.ui.reservas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.jersan.Reservar
import com.example.jersan.ReservationAdapter
import com.example.jersan.database.AppDataBaseR
import com.example.jersan.databinding.FragmentoReservasBinding
import com.example.jersan.utils.Constants
import java.util.concurrent.Executors

class ReservasFragmento : Fragment() {

    private var _binding: FragmentoReservasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter: ReservationAdapter by lazy {
        ReservationAdapter()
    }
    private val appDataBaseR: AppDataBaseR by lazy {
        AppDataBaseR.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(ReservasViewModel::class.java)

        _binding = FragmentoReservasBinding.inflate(inflater, container, false)
        val root: View = binding.root

        cargarAdaptador()
        cargarDatos()
        eventos()

        //val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            //   textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun cargarAdaptador() {
        binding.rvPet.adapter = adapter
    }

    fun cargarDatos() {
        appDataBaseR.reservacionDAO().getReservations().observe(viewLifecycleOwner, { reservations ->
            adapter.updateListPets(reservations)
        })
    }

    fun eventos() {

        adapter.setOnClickListenerReservationEdit = {
            val bundle = Bundle().apply {
                putSerializable(Constants.KEY_REV, it)
            }

            val intent = Intent(activity, Reservar::class.java)

            startActivity(intent.apply {
                putExtras(bundle)
            })

        }
        adapter.setOnClickListenerReservationDelete = {
            Executors.newSingleThreadExecutor().execute() {
                appDataBaseR.reservacionDAO().delete(it)
                //Toast.makeText(this, "Reservación eliminada!", Toast.LENGTH_LONG).show()

            }
        }
    }
}