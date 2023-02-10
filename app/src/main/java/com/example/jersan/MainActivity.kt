package com.example.jersan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jersan.database.AppDataBase
import com.example.jersan.databinding.ActivityMainBinding
import com.example.jersan.databinding.ActivityRegistroBinding
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val appDataBase: AppDataBase by lazy {
        AppDataBase.getInstance(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()

        this.login()
        this.registrar()
    }


    private fun login() {
        binding.btnIniciarSesion.setOnClickListener {

            if (binding.tvUsuario.text.toString()
                    .equals("") || binding.pasContrasenna.text.toString()
                    .equals("")
            ) {
                runOnUiThread {
                    Toast.makeText(this, "Ingrese sus credenciales", Toast.LENGTH_LONG).show()
                    binding.tvUsuario.requestFocus()
                }
            } else {
                Executors.newSingleThreadExecutor().execute() {
                    val usuario = appDataBase.usuarioDAO().getUserByUserAndPass(
                        binding.tvUsuario.text.toString(),
                        binding.pasContrasenna.text.toString()
                    )
                    if (usuario == null) {
                        runOnUiThread {
                            Toast.makeText(
                                this,
                                "Ingrese sus credenciales correctamente",
                                Toast.LENGTH_LONG
                            ).show()
                            binding.tvUsuario.requestFocus()
                        }
                    } else {
                        runOnUiThread {
                            startActivity(Intent(this, Inicio::class.java))
                            Toast.makeText(
                                this,
                                "Bienvenido: " + usuario.nombre + " " + usuario.apellido,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun registrar() {
        this.binding.btnRegistrar.setOnClickListener {
            startActivity(Intent(this, Registro::class.java))
        }
    }
}