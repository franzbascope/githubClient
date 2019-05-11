package com.example.franz.investigacion.Servicios;

import com.example.franz.investigacion.Objetos.Repositorio;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PostRepos {

    String URL= "/user/repos";

    @POST(URL)
    Call<Repositorio> postRepo(
            @Header("Authorization") String authkey
            , @Body() Repositorio Repositorio
    );
}
