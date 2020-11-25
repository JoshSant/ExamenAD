package com.example.examenad.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.examenad.AgendaApplication;
import com.example.examenad.model.dao.AgendaDao;
import com.example.examenad.model.entity.Persona;
import com.example.examenad.model.room.AgendaDatabase;

import java.util.List;

public class PersonaRepository {

    private AgendaDatabase db;

    private AgendaDao agendaDao;

    private LiveData<List<Persona>> liveListaPersonas;

    public PersonaRepository(Application context) {
        db = AgendaDatabase.getDatabase(context);
        agendaDao = db.getAgendaDao();

        //LiveData: carga de datos en segundo plano
        liveListaPersonas = agendaDao.getAllLive();
    }

    public LiveData<List<Persona>> getLiveListaPersonas() {
        return liveListaPersonas;
    }

    public void insert(Persona persona) {

        AgendaApplication.EjecutorDeHilos.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.insert(persona);
            }
        });
    }

    public void delete(int id) {

        AgendaApplication.EjecutorDeHilos.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.deletePersona(id);
            }
        });

    }

    public void edit(Persona persona) {

        AgendaApplication.EjecutorDeHilos.execute(new Runnable() {
            @Override
            public void run() {
                agendaDao.update(persona);
            }
        });

    }
}
