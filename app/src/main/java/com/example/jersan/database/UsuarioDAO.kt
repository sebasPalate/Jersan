package com.example.jersan.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.jersan.model.Usuario

@Dao
interface UsuarioDAO {
    @Insert
    fun insert(usuario: Usuario): Long

    @Update
    fun update(usuario: Usuario)

    @Delete
    fun delete(usuario: Usuario)

    @Query("select * from USUARIOS ORDER BY ID")
    fun getUsers(): LiveData<List<Usuario>>

    @Query("SELECT * FROM USUARIOS WHERE USUARIO=:usuario")
    fun getUserById(usuario: String): List<Usuario>

    @Query("SELECT * FROM USUARIOS WHERE USUARIO=:usuario AND CONTRASENNA=:contrasenia")
    fun getUserByUserAndPass(usuario: String, contrasenia: String): Usuario
}