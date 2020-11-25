package com.example.examenad.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.Date;

@Entity(tableName = "agenda")
public class Persona {

    @PrimaryKey(autoGenerate = true)
    public int id = 0;

    @NonNull
    @ColumnInfo(name = "nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name = "apellidos")
    private String apellidos;

    @NonNull
    @ColumnInfo(name = "telefono")
    private int telefono;

    @NonNull
    @ColumnInfo(name = "fechNac")
    private String fechNac;

    @NonNull
    @ColumnInfo(name = "localidad")
    private String localidad;

    @NonNull
    @ColumnInfo(name = "calle")
    private String calle;

    @NonNull
    @ColumnInfo(name = "numero")
    private int numero;

    public Persona() {
    }

    public Persona(@NonNull String nombre, @NonNull String apellidos, int telefono,
                   @NonNull String fechaNac, @NonNull String localidad,
                   @NonNull String calle, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechNac = fechaNac;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@NonNull String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(@NonNull int telefono) {
        this.telefono = telefono;
    }

    @NonNull
    public String getFechNac() {
        return fechNac;
    }

    public void setFechNac(@NonNull String fechNac) {
        this.fechNac = fechNac;
    }

    @NonNull
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(@NonNull String localidad) {
        this.localidad = localidad;
    }

    @NonNull
    public String getCalle() {
        return calle;
    }

    public void setCalle(@NonNull String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(@NonNull int numero) {
        this.numero = numero;
    }
}
