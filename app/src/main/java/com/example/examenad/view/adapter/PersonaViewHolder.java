package com.example.examenad.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenad.R;
import com.example.examenad.model.entity.Persona;
import com.example.examenad.view.AgendaActivity;

public class PersonaViewHolder extends RecyclerView.ViewHolder{

    private final TextView tvPersona;
    Button btEditar;
    Button btBorrar;
    private AgendaActivity agendaActivity;

    public PersonaViewHolder(@NonNull View v) {
        super(v);
        this.tvPersona = v.findViewById(R.id.tvPersonas);
        this.btEditar = v.findViewById(R.id.btEditar);
        this.btBorrar = v.findViewById(R.id.btBorrar);
        agendaActivity = (AgendaActivity) v.getContext();
    }

    @SuppressLint("ResourceType")
    public void bind(String text, int position) {
        tvPersona.setText(text);

        Log.v("xyz", "" + position);

        btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agendaActivity.delete(position);
            }
        });

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agendaActivity.edit(position);
            }
        });
    }

    static PersonaViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.persona, parent, false);

        return new PersonaViewHolder(view);
    }

}
