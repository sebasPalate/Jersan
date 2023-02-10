package com.example.jersan.ui.reservas

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jersan.Registro
import com.example.jersan.ReservationAdapter
import com.example.jersan.database.AppDataBase
import com.example.jersan.utils.Constants
import java.util.concurrent.Executors

class ReservasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Reservas Fragmentos"
    }
    val text: LiveData<String> = _text

}