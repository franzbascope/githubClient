package com.example.franz.investigacion.Objetos;

public class Repositorio
{
    private String name;
    private String description;
    private owner owner;

    public com.example.franz.investigacion.Objetos.owner getOwner() {
        return owner;
    }

    public void setOwner(com.example.franz.investigacion.Objetos.owner owner) {
        this.owner = owner;
    }

    public Repositorio(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Repositorio() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
