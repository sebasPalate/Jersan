package com.example.jersan.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.jersan.model.Reservacion
import com.example.jersan.ui.reservas.ReservasFragmento

@Database(entities = [Reservacion::class], version = 1, exportSchema = false)
abstract class AppDataBaseR : RoomDatabase() {
    abstract fun reservacionDAO(): ReservacionDAO

    companion object {
        var instacia: AppDataBaseR? = null

        fun getInstance(context: Context): AppDataBaseR {
            if (instacia == null) {
                instacia = Room.databaseBuilder(
                    context,
                    AppDataBaseR::class.java, "DB_RESERVACIONES"
                ).build()
            }
            return instacia as AppDataBaseR
        }

    }
}