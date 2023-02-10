package com.example.jersan.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jersan.model.Reservacion

@Dao
interface ReservacionDAO {
    @Insert
    fun insert(reservacion: Reservacion): Long

    @Update
    fun update(reservacion: Reservacion)

    @Delete
    fun delete(reservacion: Reservacion)

    @Query("select * from RESERVACIONES ORDER BY ID")
    fun getReservations(): LiveData<List<Reservacion>>

    @Query("SELECT * FROM RESERVACIONES WHERE ID=:id")
    fun getUserById(id: Int): List<Reservacion>
}