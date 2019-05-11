package com.example.franz.investigacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.franz.investigacion.Objetos.Repositorio;
import com.example.franz.investigacion.Servicios.GetRepos;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static retrofit2.converter.gson.GsonConverterFactory.create;

public class Lista extends AppCompatActivity {

    public static final String PARAM_NOMBRE="PARAM_NOMBRE";
    private String nombre;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listView = findViewById(R.id.pagination_list);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(create());

        Intent parentIntent = getIntent();
        nombre=parentIntent.getStringExtra(PARAM_NOMBRE);

        Retrofit retrofit = builder.build();

        GetRepos client = retrofit.create(GetRepos.class);
        Call<List<Repositorio>> call = client.reposForUser(nombre);

        call.enqueue(new Callback<List<Repositorio>>() {
            @Override
            public void onResponse(Call<List<Repositorio>> call, Response<List<Repositorio>> response) {
                List<Repositorio> repos = response.body();
                listView.setAdapter(new Adaptador(Lista.this, repos));
            }

            @Override
            public void onFailure(Call<List<Repositorio>> call, Throwable t) {
                Toast.makeText(Lista.this, "error :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
