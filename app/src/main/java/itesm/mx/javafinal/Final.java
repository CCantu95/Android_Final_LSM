/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Final extends Fragment {

    final Handler handler = new Handler();

    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState)
    {


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        }, 1700);

        return inflater.inflate(R.layout.activity_final,vg,false);
    }
}
