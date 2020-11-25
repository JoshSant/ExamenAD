package com.example.examenad.view.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.examenad.R;
import com.example.examenad.model.entity.Persona;
import com.example.examenad.view.AgendaActivity;
import com.example.examenad.view.EditarActivity;

import static com.example.examenad.view.AgendaActivity.NEW_PERSON_ACTIVITY_REQUEST_CODE;

public class PersonaAdapter extends ListAdapter<Persona, PersonaViewHolder> {

    public PersonaAdapter(@NonNull DiffUtil.ItemCallback<Persona> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PersonaViewHolder.create(parent);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        Persona current = getItem(position);
        holder.bind( "--------------------" +
                "\nNombre: " + current.getNombre() +
                "\nApellidos: " + current.getApellidos() +
                "\nTelefono: " + current.getTelefono() +
                "\nFecha de Nacimiento: " + current.getFechNac() +
                "\nLocalidad: " + current.getLocalidad() +
                "\nCalle: " + current.getCalle() +
                "\nNumero: " + current.getNumero(), position);
    }

    public static class PersonaDiff extends DiffUtil.ItemCallback<Persona> {

        @Override
        public boolean areItemsTheSame(@NonNull Persona oldItem, @NonNull Persona newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Persona oldItem, @NonNull Persona newItem) {
            return oldItem.getNombre().equals(newItem.getNombre());
        }
    }

}
