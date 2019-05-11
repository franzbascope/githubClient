package com.example.franz.investigacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GetRepo extends AppCompatActivity {

    private EditText txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_repo);
        txtNombre = findViewById(R.id.txtNombre);
    }

    public void enviarDatos(View view) {
        String nombre = txtNombre.getText().toString();
        if (nombre.isEmpty() || nombre == null) {
            Toast.makeText(this, "Ingrese un Usuario", Toast.LENGTH_SHORT);
        } else {
            Intent intent = new Intent(this,Lista.class);
            intent.putExtra(Lista.PARAM_NOMBRE,nombre);
            startActivity(intent);

        }
    }
}
