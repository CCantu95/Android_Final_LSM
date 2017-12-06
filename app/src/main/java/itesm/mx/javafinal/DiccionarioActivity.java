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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class DiccionarioActivity extends AppCompatActivity implements DiccionarioFragment.OnSenaSelectedListener{

    private SenasDAO senasDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.titulo_diccionario));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Drawable icon = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_filter_list_white_24dp);
        toolbar.setOverflowIcon(icon);

        senasDAO = new SenasDAO(this);
        senasDAO.open();

        if (savedInstanceState != null){
            getSupportFragmentManager().executePendingTransactions();

            Fragment fragment = getFragmentManager().findFragmentById(R.id.diccionario_container);

            if (fragment != null){
                getFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }

        if (findViewById(R.id.diccionario_container) != null){
            DiccionarioFragment diccionarioFragment = DiccionarioFragment.newInstance();

            FragmentTransaction transact = getSupportFragmentManager().beginTransaction();
            transact.replace(R.id.diccionario_container,diccionarioFragment);
            transact.commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        senasDAO.close();
        //DiccionarioFragment.ACTUAL_LISTA = 0;
        return true;
    }

    @Override
    public void onSenaSelected(int index) {
        DiccionarioDetalleFragment diccionarioDetalleFragment = DiccionarioDetalleFragment.newInstance(index);
        FragmentTransaction transact = getSupportFragmentManager().beginTransaction();
        transact.replace(R.id.diccionario_container,diccionarioDetalleFragment);
        transact.addToBackStack("");
        transact.commit();
        senasDAO.close();
    }
}
