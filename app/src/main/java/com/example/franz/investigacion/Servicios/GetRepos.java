package com.example.franz.investigacion.Servicios;

import com.example.franz.investigacion.Objetos.Repositorio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetRepos
{
    @GET("/users/{user}/repos")
    Call<List<Repositorio>> reposForUser(@Path("user") String user);

}
