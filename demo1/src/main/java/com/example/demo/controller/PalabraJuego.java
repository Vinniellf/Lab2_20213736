package com.example.demo.controller;

public class PalabraJuego {
    public String respuesta;
    public String current;
    public int intentos;

    public PalabraJuego (String respuesta, String current, int intentos){
        this.respuesta = respuesta;
        this.current = current;
        this.intentos = intentos;
    }

    public PalabraJuego(){
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
