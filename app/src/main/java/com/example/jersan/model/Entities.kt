package com.example.jersan.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "USUARIOS")
data class Usuario(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,
    @ColumnInfo(name = "USUARIO")
    var usuario: String,
    @ColumnInfo(name = "NOMBRE")
    var nombre: String,
    @ColumnInfo(name = "APELLIDO")
    var apellido: String,
    @ColumnInfo(name = "CONTRASENNA")
    var contrasenia: String
) : Serializable

@Entity(tableName = "RESERVACIONES")
data class Reservacion(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,
    @ColumnInfo(name = "LUGAR")
    var lugar: String,
    @ColumnInfo(name = "FECHA")
    var fecha: String,
    @ColumnInfo(name = "TIPO")
    var tipo: String,
    @ColumnInfo(name = "COCHE")
    var coche: String
) : Serializable