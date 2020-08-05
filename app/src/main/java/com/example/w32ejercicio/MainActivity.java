package com.example.w32ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText tietNombre;
    private DatePicker dpFechaNacimiento;
    private TextInputEditText tietTelefono;
    private TextInputEditText tietEmail;
    private TextInputEditText tietDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tietNombre = (TextInputEditText) findViewById(R.id.tiet_nombre_completo);
        this.dpFechaNacimiento = (DatePicker) findViewById(R.id.dp_fecha_nacimiento);
        this.tietTelefono = (TextInputEditText) findViewById(R.id.tiet_telefono);
        this.tietEmail = (TextInputEditText) findViewById(R.id.tiet_email);
        this.tietDescripcion = (TextInputEditText) findViewById(R.id.tiet_descripcion);


        Bundle parametros = getIntent().getExtras();

        if (parametros != null) {
            String nombre = parametros.getString(getResources().getString(R.string.parm_nombre));
            int fechaDia = parametros.getInt(getResources().getString(R.string.parm_dob_day));
            int fechaMes = parametros.getInt(getResources().getString(R.string.parm_dob_month));
            int fechaAgno = parametros.getInt(getResources().getString(R.string.parm_dob_year));
            String telefono = parametros.getString(getResources().getString(R.string.parm_telefono));
            String email = parametros.getString(getResources().getString(R.string.parm_email));
            String descripcion = parametros.getString(getResources().getString(R.string.parm_descripcion));

            this.tietNombre.setText(nombre);
            this.dpFechaNacimiento.updateDate(fechaAgno, fechaMes, fechaDia);
            this.tietTelefono.setText(telefono);
            this.tietEmail.setText(email);
            this.tietDescripcion.setText(descripcion);
        }

    }

    public void siguienteAction(View view) {
        Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
        i.putExtra(getString(R.string.parm_nombre), this.tietNombre.getText().toString());
        i.putExtra(getString(R.string.parm_dob_day), this.dpFechaNacimiento.getDayOfMonth());
        i.putExtra(getString(R.string.parm_dob_month), this.dpFechaNacimiento.getMonth());
        i.putExtra(getString(R.string.parm_dob_year), this.dpFechaNacimiento.getYear());
        i.putExtra(getString(R.string.parm_telefono), this.tietTelefono.getText().toString());
        i.putExtra(getString(R.string.parm_email), this.tietEmail.getText().toString());
        i.putExtra(getString(R.string.parm_descripcion), this.tietDescripcion.getText().toString());
        startActivity(i);
        finish();
    }
}