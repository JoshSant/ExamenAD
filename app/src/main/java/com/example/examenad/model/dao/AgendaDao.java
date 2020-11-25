package com.example.examenad.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.examenad.model.entity.Persona;

import java.util.List;

@Dao
public interface AgendaDao {

    @Query("select * from agenda order by id")
    LiveData<List<Persona>> getAllLive();

    @Query("delete from agenda where id = :id")
    void deletePersona(int id);

    /*@Delete
    void deletePersona(Persona persona);*/

    @Query("delete from agenda")
    void deleteAll();

    @Query("select * from agenda where nombre = :persona")
    Persona getNom(String persona);

    @Query("select * from agenda where apellidos = :persona")
    Persona getApe(String persona);

    @Query("select * from agenda where apellidos = :persona")
    Persona getTelef(String persona);

    @Query("select * from agenda where fechNac = :persona")
    Persona getFechNac(String persona);

    @Query("select * from agenda where localidad = :persona")
    Persona getLoc(String persona);

    @Query("select * from agenda where calle = :persona")
    Persona getCalle(String persona);

    @Query("select * from agenda where numero = :persona")
    Persona getNum(String persona);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Persona persona);

    @Update
    void update(Persona persona);
}
