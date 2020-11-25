package com.example.examenad.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.examenad.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IntroducirActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY_NOM = "com.example.examenad.NOMBRE";
    public static final String EXTRA_REPLY_APE = "com.example.examenad.APELLIDOS";
    public static final String EXTRA_REPLY_TELEF = "com.example.examenad.TELEFONO";
    public static final String EXTRA_REPLY_FECHNAC = "com.example.examenad.FECHANAC";
    public static final String EXTRA_REPLY_LOC = "com.example.examenad.LOCALIDAD";
    public static final String EXTRA_REPLY_CALLE = "com.example.examenad.CALLE";
    public static final String EXTRA_REPLY_NUM = "com.example.examenad.NUMERO";

    private EditText etNombre, etApellidos, etTelef, etFechNac, etLocalidad, etCalle, etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introducir2);

        init();
    }

    private void init() {

        etNombre = findViewById(R.id.etNombreAd);
        etApellidos = findViewById(R.id.etApellidosAd);
        etTelef = findViewById(R.id.etTelefAd);
        etFechNac = findViewById(R.id.etFechNacAd);
        etLocalidad = findViewById(R.id.etLocalidadAd);
        etCalle = findViewById(R.id.etCalleAd);
        etNumero = findViewById(R.id.etNumAd);

        final Button button = findViewById(R.id.btAñadirIntr);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(etNombre.getText()) ||
                    TextUtils.isEmpty(etApellidos.getText()) ||
                    TextUtils.isEmpty(etTelef.getText()) ||
                    TextUtils.isEmpty(etFechNac.getText()) ||
                    TextUtils.isEmpty(etLocalidad.getText()) ||
                    TextUtils.isEmpty(etCalle.getText()) ||
                    TextUtils.isEmpty(etNumero.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String nombre = etNombre.getText().toString();
                String apellidos = etApellidos.getText().toString();
                int telef = Integer.parseInt(etTelef.getText().toString());
                String fechNac = etFechNac.getText().toString();
                String localidad = etLocalidad.getText().toString();
                String calle = etCalle.getText().toString();
                int numero = Integer.parseInt(etNumero.getText().toString());

                replyIntent.putExtra(EXTRA_REPLY_NOM, nombre);
                replyIntent.putExtra(EXTRA_REPLY_APE, apellidos);
                replyIntent.putExtra(EXTRA_REPLY_TELEF, telef);
                replyIntent.putExtra(EXTRA_REPLY_FECHNAC, fechNac);
                replyIntent.putExtra(EXTRA_REPLY_LOC, localidad);
                replyIntent.putExtra(EXTRA_REPLY_CALLE, calle);
                replyIntent.putExtra(EXTRA_REPLY_NUM, numero);
                setResult(RESULT_OK, replyIntent);
            }
            finish();
        });

    }
}