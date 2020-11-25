package com.example.examenad.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.examenad.model.PersonaRepository;
import com.example.examenad.model.entity.Persona;

import java.util.List;

public class AndroidPersonaViewModel extends AndroidViewModel {

    private PersonaRepository repository;

    private LiveData<List<Persona>> livePersonas;

    public AndroidPersonaViewModel(@NonNull Application application) {
        super(application);
        repository = new PersonaRepository(application);
        livePersonas = repository.getLiveListaPersonas();
    }

    public LiveData<List<Persona>> getAllPersonas() {
        return livePersonas;
    }

    public void insert(Persona persona) {
        repository.insert(persona);
    }

    public void delete(int id){ repository.delete(id); }

    public void edit(Persona persona){repository.edit(persona);}

}
