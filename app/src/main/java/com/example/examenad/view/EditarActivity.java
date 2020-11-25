package com.example.examenad.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenad.R;
import com.example.examenad.model.entity.Persona;
import com.example.examenad.viewmodel.AndroidPersonaViewModel;
import com.google.android.material.snackbar.Snackbar;

public class EditarActivity extends AppCompatActivity {

    private int position;

    private Intent intent;

    private EditText etNombre, etApellidos, etTelef, etFechNac, etLocalidad, etCalle, etNumero;

    private AndroidPersonaViewModel androidPersonaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        position = getIntent().getIntExtra("position", 0);
        androidPersonaViewModel = new ViewModelProvider(this).
                get(AndroidPersonaViewModel.class);

        init();
    }

    private void init() {

        etNombre = findViewById(R.id.etNombreEd);
        etApellidos = findViewById(R.id.etApellidosEd);
        etTelef = findViewById(R.id.etTelefonoEd);
        etFechNac = findViewById(R.id.etFechNacEd);
        etLocalidad = findViewById(R.id.etLocalidadEd);
        etCalle = findViewById(R.id.etCalleEd);
        etNumero = findViewById(R.id.etNumeroEd);

        Button btEditar = findViewById(R.id.btEditarEd);
        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(etNombre.getText()) ||
                        TextUtils.isEmpty(etApellidos.getText()) ||
                        TextUtils.isEmpty(etTelef.getText()) ||
                        TextUtils.isEmpty(etFechNac.getText()) ||
                        TextUtils.isEmpty(etLocalidad.getText()) ||
                        TextUtils.isEmpty(etCalle.getText()) ||
                        TextUtils.isEmpty(etNumero.getText())) {
                    Snackbar.make(v, "Algún campo esta vaciío", Snackbar.LENGTH_LONG).show();
                } else {
                    String nombre = etNombre.getText().toString();
                    String apellidos = etApellidos.getText().toString();
                    int telef = Integer.parseInt(etTelef.getText().toString());
                    String fechNac = etFechNac.getText().toString();
                    String localidad = etLocalidad.getText().toString();
                    String calle = etCalle.getText().toString();
                    int numero = Integer.parseInt(etNumero.getText().toString());

                    AgendaActivity agendaActivity = new AgendaActivity();
                    agendaActivity.delete(position);
                    Persona persona = new Persona
                            (nombre, apellidos, telef, fechNac, localidad, calle, numero);
                    androidPersonaViewModel.insert(persona);

                }
                finish();
            }
        });

    }
}