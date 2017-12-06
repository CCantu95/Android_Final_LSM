/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class DiccionarioFragment extends Fragment implements AdapterView.OnItemClickListener{
    public static long ACTUAL_LISTA = 0;
    ListView lvDiccionario;
    private CategoriasDAO catDAO;
    String[] listaNombreSenas;
    ArrayAdapter<String> adapterSenas;
    private SenasDAO senasDAO;
    public static ArrayList<Senas> listaSenas = new ArrayList<>();
    OnSenaSelectedListener onSenaSelectedListener;
    long idCat = 0;

    public DiccionarioFragment() {
        // Required empty public constructor
    }

    public static DiccionarioFragment newInstance(){
        DiccionarioFragment diccionarioFragment = new DiccionarioFragment();
        return diccionarioFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diccionario, container, false);

        lvDiccionario = (ListView)view.findViewById(R.id.lv_diccionario);

        senasDAO = new SenasDAO(getActivity().getApplicationContext());
        senasDAO.open();

        if (ACTUAL_LISTA == 0){
            listaSenas = showSenas();
        }
        else{
            listaSenas = senasDAO.getSenasFromCategoria(ACTUAL_LISTA);
        }
        listaNombreSenas = new String[listaSenas.size()];
        int iX = 0;
        for(Senas senas : listaSenas){
            listaNombreSenas[iX++] = senas.getNombreSena();
        }

        adapterSenas = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_activated_1,listaNombreSenas);

        lvDiccionario.setAdapter(adapterSenas);
        lvDiccionario.setOnItemClickListener(this);

        setHasOptionsMenu(true);

        return view;
    }

    public ArrayList<Senas> showSenas(){
        senasDAO = new SenasDAO(getActivity().getApplicationContext());
        ArrayList<Senas>  listaSenas = senasDAO.getSenas2();
        if (listaSenas != null){
            return listaSenas;
        }
        else{
            return null;
        }
    }

    /*@Override
    public void onResume(){
        senasDAO.open();
        super.onResume();
    }

    @Override
    public void onPause(){
        senasDAO.close();
        super.onPause();
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.filter_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.abecedario) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 1;
            ACTUAL_LISTA = 1;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.animales) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 2;
            ACTUAL_LISTA = 2;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.colores) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 3;
            ACTUAL_LISTA = 3;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.comida) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 4;
            ACTUAL_LISTA = 4;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.fechas) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 5;
            ACTUAL_LISTA = 5;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.familia) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 6;
            ACTUAL_LISTA = 6;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.numeros) {
            senasDAO = new SenasDAO(getActivity().getApplicationContext());
            idCat = 7;
            ACTUAL_LISTA = 7;
            listaSenas = senasDAO.getSenasFromCategoria(idCat);
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }
        if (id == R.id.todos) {
            listaSenas = showSenas();
            ACTUAL_LISTA = 0;
            listaNombreSenas = getNombresFromLista(listaSenas);
            adapterSenas = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_list_item_activated_1,listaNombreSenas);

            lvDiccionario.setAdapter(adapterSenas);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String[] getNombresFromLista(ArrayList<Senas> arrayListSenas){
        String[] listaNombres = new String[arrayListSenas.size()];
        int iX = 0;
        for(Senas senas : arrayListSenas){
            listaNombres[iX++] = senas.getNombreSena();
        }
        return listaNombres;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if (context instanceof DiccionarioFragment.OnSenaSelectedListener){
            onSenaSelectedListener = (DiccionarioFragment.OnSenaSelectedListener) context;
        }
        else{
            throw new ClassCastException(context.toString() + "You must use OnSenaSelectedListener.");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        onSenaSelectedListener.onSenaSelected(i);
    }


    public interface OnSenaSelectedListener{
        public void onSenaSelected(int index);
    }
}
