package com.example.jersan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jersan.database.AppDataBase
import com.example.jersan.databinding.ActivityRegistroBinding
import com.example.jersan.model.Usuario
import com.example.jersan.utils.Constants
import java.util.concurrent.Executors

class Registro : AppCompatActivity() {

    private lateinit var binding: ActivityRegistroBinding
    private var id = 0
    private val appDataBase: AppDataBase by lazy {
        AppDataBase.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        evento()
    }


    private fun inicizalizar() {
        val bundle = intent.extras
        bundle?.let {
            val usuario = bundle.getSerializable(Constants.KEY_USER) as Usuario
            binding.btnConfirmar.text = "Actualizar"
            binding.tvUsuarioRegistro.setText(usuario.usuario)
            binding.tvNombreRegistro.setText(usuario.nombre)
            binding.tvApellidoRegistro.setText(usuario.apellido)
            binding.tvNombreRegistro.setText(usuario.contrasenia)
        } ?: kotlin.run {
            binding.btnConfirmar.text = "Registar"
            binding.tvUsuarioRegistro.setText("")
            binding.tvNombreRegistro.setText("")
            binding.tvApellidoRegistro.setText("")
            binding.tvContraseniaRegistro.setText("")
        }
        binding.tvUsuarioRegistro.requestFocus()
    }

    private fun evento() {
        binding.btnConfirmar.setOnClickListener {
            val usuario = binding.tvUsuarioRegistro.text.toString()
            val nombre = binding.tvNombreRegistro.text.toString()
            val apellido = binding.tvApellidoRegistro.text.toString()
            val contraseña = binding.tvContraseniaRegistro.text.toString()
            if (id == 0) {
                agregar(Usuario(0, usuario, nombre, apellido, contraseña))
            } else {
                //editar(Pet(id, nombre, raza, preferencias))
                Toast.makeText(this, "Editar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun agregar(usuario: Usuario) {
        Executors.newSingleThreadExecutor().execute() {
            appDataBase.usuarioDAO().insert(usuario)
            runOnUiThread {
                Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_LONG).show()
                onBackPressed()
            }
        }
    }


}