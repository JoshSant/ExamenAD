package com.example.examenad.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.examenad.model.PersonaRepository;
import com.example.examenad.model.entity.Persona;

import java.util.List;

public class PersonaViewModel extends ViewModel {

    private PersonaRepository repository;

    private LiveData<List<Persona>> livePersonas;

    public PersonaViewModel() {
        super();
        //repository = new PalabroRepository(application);
        //livePalabros = repository.getLiveListaPalabros();
    }

    public void setContext(Application application) {
        repository = new PersonaRepository(application);
        livePersonas = repository.getLiveListaPersonas();
    }

    public LiveData<List<Persona>> getAllPersonas() {
        return livePersonas;
    }

    public void insert(Persona persona) {
        repository.insert(persona);
    }

}
