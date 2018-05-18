package com.example.jpablos.fragments;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jpablos on 27/03/2018.
 */

public class DatosParcelable implements Parcelable {
    private String cadena;
    private int numero;

    public DatosParcelable(String cadena, int numero) {
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

    protected DatosParcelable(Parcel in) {
        cadena = in.readString();
        numero = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(cadena);
        dest.writeInt(numero);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DatosParcelable> CREATOR = new Creator<DatosParcelable>() {
        @Override
        public DatosParcelable createFromParcel(Parcel in) {
            return new DatosParcelable(in);
        }

        @Override
        public DatosParcelable[] newArray(int size) {
            return new DatosParcelable[size];
        }
    };
}
