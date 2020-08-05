package com.example.w32ejercicio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class ConfirmarDatos extends AppCompatActivity {

    private EditText etNombre;
    private EditText etFechaNacimiento;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        this.etNombre = (EditText) findViewById(R.id.et_nombre);
        this.etFechaNacimiento = (EditText) findViewById(R.id.et_fecha_nacimiento);
        this.etTelefono = (EditText) findViewById(R.id.et_telefono);
        this.etEmail = (EditText) findViewById(R.id.et_email);
        this.etDescripcion = (EditText) findViewById(R.id.et_descripcion);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.parm_nombre));
        String fechaNacimiento = (1 + parametros.getInt(getResources().getString(R.string.parm_dob_month))) + "/" +
                parametros.getInt(getResources().getString(R.string.parm_dob_day)) + "/" +
                parametros.getInt(getResources().getString(R.string.parm_dob_year));
        String telefono = parametros.getString(getResources().getString(R.string.parm_telefono));
        String email = parametros.getString(getResources().getString(R.string.parm_email));
        String descripcion = parametros.getString(getResources().getString(R.string.parm_descripcion));

        this.etNombre.setText(nombre);
        this.etFechaNacimiento.setText(fechaNacimiento);
        this.etTelefono.setText(telefono);
        this.etEmail.setText(email);
        this.etDescripcion.setText(descripcion);
    }

    public void editarAction(View view) {
        lanzarMainActivity();
    }

    private void lanzarMainActivity() {
        Bundle parametros = getIntent().getExtras();

        Intent i = new Intent(ConfirmarDatos.this, MainActivity.class);

        i.putExtra(getString(R.string.parm_nombre), parametros.getString(getResources().getString(R.string.parm_nombre)));
        i.putExtra(getString(R.string.parm_dob_day), parametros.getInt(getResources().getString(R.string.parm_dob_day)));
        i.putExtra(getString(R.string.parm_dob_month), parametros.getInt(getResources().getString(R.string.parm_dob_month)));
        i.putExtra(getString(R.string.parm_dob_year), parametros.getInt(getResources().getString(R.string.parm_dob_year)));
        i.putExtra(getString(R.string.parm_telefono), parametros.getString(getResources().getString(R.string.parm_telefono)));
        i.putExtra(getString(R.string.parm_email), parametros.getString(getResources().getString(R.string.parm_email)));
        i.putExtra(getString(R.string.parm_descripcion), parametros.getString(getResources().getString(R.string.parm_descripcion)));
        startActivity(i);
        finish();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            lanzarMainActivity();
        }
        return super.onKeyDown(keyCode, event);
    }
}