package com.example.jersan.database

import com.example.jersan.model.Usuario
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jersan.ui.reservas.ReservasFragmento

@Database(entities = [Usuario::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO

    companion object {
        var instacia: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (instacia == null) {
                instacia = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "BD_USUARIOS"
                ).build()
            }
            return instacia as AppDataBase
        }

    }
}