package com.example.jersan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jersan.databinding.ItemReservationBinding
import com.example.jersan.model.Reservacion

class ReservationAdapter(var reservations: List<Reservacion> = emptyList()) :
    RecyclerView.Adapter<ReservationAdapter.ReservationAdapterViewHolder>() {

    lateinit var setOnClickListenerReservationEdit: (Reservacion) -> Unit
    lateinit var setOnClickListenerReservationDelete: (Reservacion) -> Unit

    //Crear el ViewHolder
    inner class ReservationAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var binding: ItemReservationBinding = ItemReservationBinding.bind(itemView)

        fun bind(reservacion: Reservacion) {
            binding.txtFecha.text = reservacion.fecha
            binding.txtUbicacion.text = reservacion.lugar
            binding.txtCarro.text = reservacion.coche
            binding.txtEntrega.text = reservacion.tipo

            binding.btnEditar.setOnClickListener {
                setOnClickListenerReservationEdit(reservacion)
            }

            binding.btnEliminar.setOnClickListener {
                setOnClickListenerReservationDelete(reservacion)
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReservationAdapterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reservation, parent, false)
        return ReservationAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationAdapterViewHolder, position: Int) {
        val reservation = reservations[position]
        holder.bind(reservation)
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    fun updateListPets(reservations: List<Reservacion>) {
        this.reservations = reservations
        notifyDataSetChanged()
    }
}