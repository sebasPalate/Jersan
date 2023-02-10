package com.example.jersan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jersan.database.AppDataBase
import com.example.jersan.database.AppDataBaseR
import com.example.jersan.databinding.ActivityReservarBinding
import com.example.jersan.model.Reservacion
import com.example.jersan.utils.Constants
import com.example.jersan.utils.Constants.Companion
import java.util.concurrent.Executors

class Reservar : AppCompatActivity() {

    private lateinit var binding: ActivityReservarBinding;
    private var id = 0;


    private val appDataBaseR: AppDataBaseR by lazy {
        AppDataBaseR.getInstance(this);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityReservarBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_reservar)
        setContentView(binding.root)
        inicializar()
        evento()
    }

    private fun inicializar() {
        val bundle = intent.extras
        bundle?.let {
            val reservarcion = bundle.getSerializable(Constants.KEY_REV) as Reservacion
            binding.editLugar.setText("");
            binding.editLugar.setText("");
            binding.editLugar.requestFocus();
        }
    }

    private fun evento() {
        binding.btnConfirmarReservacion.setOnClickListener {
            val lugar = binding.editLugar.text.toString();
            val fecha = binding.fecha.date.toString();

            val condicion = binding.tipoEntrega.isChecked;
            var tipo = ""
            if (condicion == true) {
                tipo = "Entregamos y Recogemos"
            } else {
                tipo = "Estacion Cercana"
            }
            //val tipo = binding.tipo.checkedRadioButtonId.toString()
            val coche = binding.editCoche.text.toString();

            if (id == 0){
                agregar(Reservacion(0, lugar, fecha, tipo, coche))
            } else {
                editar(Reservacion(id, lugar, fecha, tipo, coche))
            }
        }
    }

    fun agregar(reservacion: Reservacion){
        Executors.newSingleThreadExecutor().execute() {
            appDataBaseR.reservacionDAO().insert(reservacion)
            runOnUiThread {
                Toast.makeText(this, "Reservacion Registrada!", Toast.LENGTH_LONG).show()
                onBackPressed()
            }
        }
    }

    fun editar(reservacion: Reservacion) {
        Executors.newSingleThreadExecutor().execute() {
            appDataBaseR.reservacionDAO().update(reservacion)
            runOnUiThread {
                Toast.makeText(this, "Reservación Actualizada!", Toast.LENGTH_LONG).show()
                onBackPressed()
            }
        }
    }

}