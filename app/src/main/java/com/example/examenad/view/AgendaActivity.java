package com.example.examenad.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.examenad.R;
import com.example.examenad.model.dao.AgendaDao;
import com.example.examenad.model.entity.Persona;
import com.example.examenad.view.adapter.PersonaAdapter;
import com.example.examenad.view.adapter.PersonaViewHolder;
import com.example.examenad.viewmodel.AndroidPersonaViewModel;
import com.example.examenad.viewmodel.PersonaViewModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AgendaActivity extends AppCompatActivity{

    public static final int NEW_PERSON_ACTIVITY_REQUEST_CODE = 1;

    private PersonaViewModel viewModel;
    private static AndroidPersonaViewModel androidViewModel;
    private Date date;
    private AgendaDao agendaDao;
    private PersonaViewHolder viewHolder;
    final PersonaAdapter adapter = new PersonaAdapter(new PersonaAdapter.PersonaDiff());

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == NEW_PERSON_ACTIVITY_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                String Nombre = data.getStringExtra(IntroducirActivity.EXTRA_REPLY_NOM);
                String Apellidos = data.getStringExtra(IntroducirActivity.EXTRA_REPLY_APE);
                int Telefono = data.getIntExtra(IntroducirActivity.EXTRA_REPLY_TELEF,
                        00000000);
                String FechNac = data.getStringExtra(IntroducirActivity.EXTRA_REPLY_FECHNAC);
                String Localidad = data.getStringExtra(IntroducirActivity.EXTRA_REPLY_LOC);
                String Calle = data.getStringExtra(IntroducirActivity.EXTRA_REPLY_CALLE);
                int Numero = data.getIntExtra(IntroducirActivity.EXTRA_REPLY_NUM,
                        00000000);

                androidViewModel.insert(new Persona(Nombre, Apellidos, Telefono, FechNac,
                        Localidad, Calle, Numero));
            } else if(resultCode == RESULT_CANCELED) {
                Toast.makeText(
                        getApplicationContext(),
                        "La persona no se ha guardado porque está vacío",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidViewModel = new ViewModelProvider(this).get(AndroidPersonaViewModel.class);
        init();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        Button btListar = findViewById(R.id.btListar);
        Button btAñadir = findViewById(R.id.btAñadir);

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
            }
        });

        btAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AgendaActivity.this, IntroducirActivity.class);
                startActivityForResult(intent, NEW_PERSON_ACTIVITY_REQUEST_CODE);
            }
        });

        androidViewModel.getAllPersonas().observe(this, new Observer<List<Persona>>() {
            @Override
            public void onChanged(List<Persona> personas) {
                Log.v("xyz", "onChanged: " + personas.toString());
                adapter.submitList(personas);
            }
        });
    }

    public void delete(int position){
        androidViewModel.delete
                (androidViewModel.getAllPersonas().getValue().get(position).getId());
    }

    public void edit(int position){
        Intent intent = new Intent(AgendaActivity.this, EditarActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}