package com.example.jersan.ui.comienzo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComienzoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Fragmento Comienzo"
    }
    val text: LiveData<String> = _text
}