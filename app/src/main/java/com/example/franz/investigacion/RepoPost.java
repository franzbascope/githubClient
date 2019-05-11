package com.example.franz.investigacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.franz.investigacion.Objetos.Repositorio;
import com.example.franz.investigacion.Servicios.PostRepos;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static retrofit2.converter.gson.GsonConverterFactory.create;

public class RepoPost extends AppCompatActivity {

    public static final String PARAM_USUARIO = "PARAM_USUARIO";
    public static final String PARAM_SENHA = "PARAM_SENHA";
    EditText txtNombre;
    EditText txtDescripcion;
    Retrofit.Builder builder;
    private String usuario;
    private String senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_post);

        builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(create());


        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcion = findViewById(R.id.txtDescripcion);

        Intent parentIntent = getIntent();
        usuario = parentIntent.getStringExtra(PARAM_USUARIO);
        senha = parentIntent.getStringExtra(PARAM_SENHA);


    }

    public Repositorio cargarRepositorio() {
        Repositorio repo = new Repositorio();
        if (usuario.isEmpty() || usuario == null) {
            Toast.makeText(this.getBaseContext(), "Debe Ingresar un Usuario", Toast.LENGTH_LONG);

        } else if (senha.isEmpty() || senha == null) {
            Toast.makeText(this.getBaseContext(), "Debe Ingresar una Contraseña", Toast.LENGTH_LONG);
        } else {

            repo.setName(txtNombre.getText().toString());
            repo.setDescription(txtDescripcion.getText().toString());
        }
        return repo;

    }

    public void crearRepositorio(View view) {
        Repositorio repo= cargarRepositorio();
        String base= usuario+":"+senha;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(),Base64.NO_WRAP);

        Retrofit retrofit = builder.build();

        PostRepos client = retrofit.create(PostRepos.class);
        Call<Repositorio> call = client.postRepo(authHeader,repo);

        call.enqueue(new Callback<Repositorio>() {

            @Override
            public void onResponse(Call<Repositorio> call, Response<Repositorio> response) {

                Repositorio repo = response.body();
                Intent intent = new Intent(RepoPost.this,Lista.class);
                intent.putExtra(Lista.PARAM_NOMBRE,repo.getOwner().getLogin());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Repositorio> call, Throwable t) {

                Toast.makeText(RepoPost.this,"Fallo",Toast.LENGTH_SHORT);

            }
        });


    }
}
