package com.example.franz.investigacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtUsuario;
    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
    }

    public void postRepositorios(View view)
    {
        String usuario=txtUsuario.getText().toString();
        String senha=txtSenha.getText().toString();

        if(usuario.isEmpty() || usuario==null)
        {
            Toast.makeText(this.getBaseContext(),"Debe Ingresar un Usuario",Toast.LENGTH_LONG);
            return;
        }

        if(senha.isEmpty() || senha==null)
        {
            Toast.makeText(this.getBaseContext(),"Debe Ingresar una Contraseña",Toast.LENGTH_LONG);
            return;
        }

        Intent intent = new Intent(this, RepoPost.class);
        intent.putExtra(RepoPost.PARAM_USUARIO, usuario);
        intent.putExtra(RepoPost.PARAM_SENHA, senha);
        startActivity(intent);


    }

    public void getRepositorios(View view)
    {
        Intent intent = new Intent(this,GetRepo.class);
        startActivity(intent);


    }

}
