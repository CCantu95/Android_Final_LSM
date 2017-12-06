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


public class CategoriaSenas implements Serializable{
    private String nombreCategoria;
    //private int idCategoria;
    private long idCategoriaDB;

    public CategoriaSenas(){}

    public CategoriaSenas(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaSenas(long idCategoriaDB, String nombreCategoria) {
        this.idCategoriaDB = idCategoriaDB;
        this.nombreCategoria = nombreCategoria;
    }

    /*public CategoriaSenas(int idCategoria, String nombreCategoria){
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }*/

    /*public int getIdCategoria() {
        return idCategoria;
    }*/

    /*public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }*/

    public long getIdCategoriaDB() {
        return idCategoriaDB;
    }

    public void setIdCategoriaDB(long idCategoriaDB) {
        this.idCategoriaDB = idCategoriaDB;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}
