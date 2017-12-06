/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import java.io.Serializable;


public class Senas implements Serializable{
    private long idSena;
    private String nombreSena;
    private int resourceSena;
    private CategoriaSenas categoriaSenas;


    public Senas(){}

    public Senas(String nombreSena, int resourceSena) {
        this.nombreSena = nombreSena;
        this.resourceSena = resourceSena;
    }

    public Senas(long idSena, String nombreSena, int resourceSena) {
        this.idSena = idSena;
        this.nombreSena = nombreSena;
        this.resourceSena = resourceSena;
    }

    public String getNombreSena() {
        return nombreSena;
    }

    public void setNombreSena(String nombreSena) {
        this.nombreSena = nombreSena;
    }

    public int getResourceSena() {
        return resourceSena;
    }

    public void setResourceSena(int resourceSena) {
        this.resourceSena = resourceSena;
    }

    public long getIdSena() {
        return idSena;
    }

    public void setIdSena(long idSena) {this.idSena = idSena;}

    public CategoriaSenas getCategoriaSenas() {
        return categoriaSenas;
    }

    public void setCategoriaSenas(CategoriaSenas categoriaSenas) {
        this.categoriaSenas = categoriaSenas;
    }
}
