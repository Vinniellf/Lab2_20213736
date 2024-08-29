package com.example.demo.controller;


public class Palabra {
    private String nombre;
    private int longitud;
    private String tipo;


    public Palabra (String nombre, int longitud, String tipo){
        this.nombre = nombre;
        this.longitud = longitud;
        this.tipo = tipo;
    }

    public Palabra(){
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }


}
