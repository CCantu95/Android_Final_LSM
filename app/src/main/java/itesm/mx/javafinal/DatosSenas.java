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

import java.util.ArrayList;


public class DatosSenas extends Application {
    private ArrayList<Senas> listaAbecedario;
    private ArrayList<Senas> listaAnimales;
    private ArrayList<Senas> listaColores;
    private ArrayList<Senas> listaComida;
    private ArrayList<Senas> listaDias;
    private ArrayList<Senas> listaMeses;
    private ArrayList<Senas> listaFamilia;
    private ArrayList<Senas> listaNumeros;

    public void setListaAbecedario(){
        listaAbecedario = getListaAbecedario();
    }

    public void setListaAnimales(){
        listaAnimales = getListaAnimales();
    }

    public void setListaColores(){
        listaColores = getListaColores();
    }

    public void setListaComida(){
        listaComida = getListaComida();
    }

    public void setListaDias(){
        listaDias = getListaDias();
    }

    public void setListaMeses(){
        listaMeses = getListaMeses();
    }

    public void setListaFamilia(){
        listaFamilia = getListaFamilia();
    }

    public void setListaNumeros(){
        listaNumeros = getListaNumeros();
    }

    public ArrayList<Senas> getListaAbecedario(){

        Senas senas;
        listaAbecedario = new ArrayList<>();

        senas = new Senas("A",R.drawable.a);
        listaAbecedario.add(senas);

        senas = new Senas("B",R.drawable.b);
        listaAbecedario.add(senas);

        senas = new Senas("C",R.drawable.c);
        listaAbecedario.add(senas);

        senas = new Senas("D",R.drawable.d);
        listaAbecedario.add(senas);

        senas = new Senas("E",R.drawable.e);
        listaAbecedario.add(senas);

        senas = new Senas("F",R.drawable.f);
        listaAbecedario.add(senas);

        senas = new Senas("G",R.drawable.g);
        listaAbecedario.add(senas);

        senas = new Senas("H",R.drawable.h);
        listaAbecedario.add(senas);

        senas = new Senas("I",R.drawable.i);
        listaAbecedario.add(senas);

        senas = new Senas("J",R.raw.j);
        listaAbecedario.add(senas);

        senas = new Senas("K",R.raw.k);
        listaAbecedario.add(senas);

        senas = new Senas("L",R.drawable.l);
        listaAbecedario.add(senas);

        senas = new Senas("Ll",R.raw.ll);
        listaAbecedario.add(senas);

        senas = new Senas("M",R.drawable.m);
        listaAbecedario.add(senas);

        senas = new Senas("N",R.drawable.n);
        listaAbecedario.add(senas);

        senas = new Senas("O",R.drawable.o);
        listaAbecedario.add(senas);

        senas = new Senas("P",R.drawable.p);
        listaAbecedario.add(senas);

        senas = new Senas("Q",R.raw.q);
        listaAbecedario.add(senas);

        senas = new Senas("R",R.drawable.r);
        listaAbecedario.add(senas);

        senas = new Senas("Rr",R.raw.rr);
        listaAbecedario.add(senas);

        senas = new Senas("S",R.drawable.s);
        listaAbecedario.add(senas);

        senas = new Senas("T",R.drawable.t);
        listaAbecedario.add(senas);

        senas = new Senas("U",R.drawable.u);
        listaAbecedario.add(senas);

        senas = new Senas("V",R.drawable.v);
        listaAbecedario.add(senas);

        senas = new Senas("W",R.drawable.w);
        listaAbecedario.add(senas);

        senas = new Senas("X",R.raw.x);
        listaAbecedario.add(senas);

        senas = new Senas("Y",R.drawable.y);
        listaAbecedario.add(senas);

        senas = new Senas("Z",R.raw.z);
        listaAbecedario.add(senas);

        return listaAbecedario;
    }

    public ArrayList<Senas> getListaAnimales() {
        return listaAnimales;
    }

    public ArrayList<Senas> getListaColores() {
        return listaColores;
    }

    public ArrayList<Senas> getListaComida() {
        return listaComida;
    }

    public ArrayList<Senas> getListaDias() {
        return listaDias;
    }

    public ArrayList<Senas> getListaMeses() {
        return listaMeses;
    }

    public ArrayList<Senas> getListaFamilia() {
        return listaFamilia;
    }

    public ArrayList<Senas> getListaNumeros() {
        return listaNumeros;
    }
}