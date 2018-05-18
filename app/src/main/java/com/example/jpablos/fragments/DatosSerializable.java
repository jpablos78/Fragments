package com.example.jpablos.fragments;

import java.io.Serializable;

/**
 * Created by jpablos on 27/03/2018.
 */

public class DatosSerializable implements Serializable {
    private String cadena;
    private int numero;

    public DatosSerializable(String cadena, int numero) {
        this.cadena = cadena;
        this.numero = numero;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
