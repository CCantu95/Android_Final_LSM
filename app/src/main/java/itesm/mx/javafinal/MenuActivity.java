/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MenuActivity extends AppCompatActivity {

    SenasDAO senasDA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        senasDA = new SenasDAO(this);
        senasDA.open();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        getSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.titulo_juego));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        int displaymode = getResources().getConfiguration().orientation;
        if(displaymode == 1){// portrait
            OpcionesActivity O1 = new OpcionesActivity();
            fragmentTransaction.replace(android.R.id.content,O1);
        }else {// landscape
            //Main2 f2 = new Main2();
            //fragmentTransaction.replace(android.R.id.content,f2);
        }
        fragmentTransaction.commit();


    }

    private void getSupportActionBar(Toolbar toolbar) {

    }

    @Override
    public boolean onSupportNavigateUp()
    {
        onBackPressed();

        return true;
    }


}
