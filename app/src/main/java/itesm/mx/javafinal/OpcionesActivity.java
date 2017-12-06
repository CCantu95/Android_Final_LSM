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
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class OpcionesActivity extends Fragment implements View.OnClickListener{

    Button animales, personas, colores, comida, abc, fecha, num, ale;
    //TextView t;
    public ArrayList<String> palabras;
    private SQLiteDatabase db;
    private DBHelper helper;
    private Context dbContext;
    SenasDAO ss;


    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_opciones,vg,false);

        ss = new SenasDAO(getActivity().getApplicationContext());

        //db = helper.getReadableDatabase();
        //db = helper.getWritableDatabase();

        animales = rootView.findViewById(R.id.buton_animales);
        personas = rootView.findViewById(R.id.buton_familia);
        colores = rootView.findViewById(R.id.buton_colores);
        comida = rootView.findViewById(R.id.buton_comida);
        abc = rootView.findViewById(R.id.buton_abc);
        fecha = rootView.findViewById(R.id.buton_fecha);
        num = rootView.findViewById(R.id.buton_num);
        //t = rootView.findViewById(R.id.tex);


        animales.getBackground().setColorFilter(Color.parseColor("#fc9a01"), PorterDuff.Mode.MULTIPLY); //2
        personas.getBackground().setColorFilter(Color.parseColor("#fc9af7"), PorterDuff.Mode.MULTIPLY); //6
        colores.getBackground().setColorFilter(Color.parseColor("#a2741d"), PorterDuff.Mode.MULTIPLY);  //3
        comida.getBackground().setColorFilter(Color.parseColor("#fdf502"), PorterDuff.Mode.MULTIPLY);   //4
        abc.getBackground().setColorFilter(Color.parseColor("#2df502"), PorterDuff.Mode.MULTIPLY);     //1
        fecha.getBackground().setColorFilter(Color.parseColor("#851cfa"), PorterDuff.Mode.MULTIPLY);   //5
        num.getBackground().setColorFilter(Color.parseColor("#99a49d"), PorterDuff.Mode.MULTIPLY);     //7
//        t.setBackgroundColor(Color.parseColor("#fffeff"));


        animales.setOnClickListener(this);
        personas.setOnClickListener(this);
        colores.setOnClickListener(this);
        comida.setOnClickListener(this);
        abc.setOnClickListener(this);
        fecha.setOnClickListener(this);
        num.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View view) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        Fragment f = getFragmentManager().findFragmentByTag("fff");
        int displaymode = getResources().getConfiguration().orientation;
        long id = 0;

        switch(view.getId())
        {
            case R.id.buton_animales:
                id = 2;

                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);


                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_familia:
                id = 6;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_colores:
                id = 3;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_comida:
                id = 4;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_abc:
                id = 1;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_fecha:
                id = 5;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;
            case R.id.buton_num:
                id = 7;
                GameActivity.ListaSenas = ss.getSenasFromCategoria(id);

                if(displaymode == 1){// portrait
                    GameActivity G1 = new GameActivity();
                    fragmentTransaction.replace(android.R.id.content,G1);
                }else {// landscape
                    //Main2 f2 = new Main2();
                    //fragmentTransaction.replace(android.R.id.content,f2);
                }
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();
                break;

                }

        }
    }

