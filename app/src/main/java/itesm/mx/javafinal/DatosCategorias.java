/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.app.Application;


public class DatosCategorias extends Application {
    public static CategoriaSenas categoriaAbecedario = new CategoriaSenas("ABECEDARIO");
    public static CategoriaSenas categoriaAnimales = new CategoriaSenas("ANIMALES");

}
