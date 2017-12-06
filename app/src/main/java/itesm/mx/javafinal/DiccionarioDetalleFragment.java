/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;


import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;


public class DiccionarioDetalleFragment extends Fragment implements View.OnTouchListener{

    final static String SENA_INDEX = "sena_index";
    ImageView iv_foto;
    VideoView vv_video;
    TextView tv_nombre_sena,tv_categoria;
    private int actualIndexSena = 0;
    ArrayList<Senas> senasActuales;
    private SenasDAO senasDAO;
    String fullPath;
    String pathExtension;
    GestureDetectorCompat mDetector;

    public DiccionarioDetalleFragment() {
        // Required empty public constructor
    }

    public static DiccionarioDetalleFragment newInstance(int indexSena){
        DiccionarioDetalleFragment diccionarioDetalleFragment = new DiccionarioDetalleFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(SENA_INDEX,indexSena);
        diccionarioDetalleFragment.setArguments(bundle);

        return diccionarioDetalleFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_diccionario_detalle, container, false);

        tv_categoria = (TextView)view.findViewById(R.id.tv_categoria);
        tv_nombre_sena = (TextView)view.findViewById(R.id.tv_nombre_sena);
        iv_foto = (ImageView)view.findViewById(R.id.iv_Foto);
        vv_video = (VideoView)view.findViewById(R.id.vv_Video);

        vv_video.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                vv_video.start();
            }
        });

        fullPath = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/";

        senasDAO = new SenasDAO(getActivity().getApplicationContext());

        MyGestureListener myGestureListener = new MyGestureListener();
        mDetector = new GestureDetectorCompat(getActivity(),myGestureListener);

        view.setOnTouchListener(this);

        setHasOptionsMenu(false);

        return view;
    }

    @Override
    public void onResume(){
        senasDAO.open();
        super.onResume();
    }

    @Override
    public void onPause(){
        senasDAO.close();
        super.onPause();
    }

    @Override
    public void onStart(){
        super.onStart();

        if (getArguments() != null){
            actualIndexSena = getArguments().getInt(SENA_INDEX);
        }
        setSenaView(actualIndexSena);
    }
    public void setSenaView(int position){
        Senas senas = DiccionarioFragment.listaSenas.get(position);

        fullPath+=senas.getResourceSena();
        pathExtension = getFileExtension(fullPath);

        if (pathExtension.equals("JPG")){
            vv_video.setVisibility(View.GONE);
            iv_foto.setVisibility(View.VISIBLE);
            iv_foto.setImageResource(senas.getResourceSena());
        }
        else{
            iv_foto.setVisibility(View.GONE);
            vv_video.setVisibility(View.VISIBLE);
            vv_video.setVideoURI(Uri.parse(fullPath));
            vv_video.start();
        }
        tv_nombre_sena.setText(senas.getNombreSena());
        tv_categoria.setText(senas.getCategoriaSenas().getNombreCategoria());

        senasDAO.close();

        //Reinicia el valor de
        fullPath = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/";
        pathExtension = "";

        if(senas.getCategoriaSenas().getIdCategoriaDB() == 1){
            tv_categoria.setBackgroundColor(Color.parseColor("#2df502"));
        }
        else if(senas.getCategoriaSenas().getIdCategoriaDB() == 2){
            tv_categoria.setBackgroundColor(Color.parseColor("#fc9a01"));
        }
        else if(senas.getCategoriaSenas().getIdCategoriaDB() == 3){
            tv_categoria.setBackgroundColor(Color.parseColor("#a2741d"));
        }
        else if(senas.getCategoriaSenas().getIdCategoriaDB() == 4){
            tv_categoria.setBackgroundColor(Color.parseColor("#fdf502"));
        }
        else if(senas.getCategoriaSenas().getIdCategoriaDB() == 5){
            tv_categoria.setBackgroundColor(Color.parseColor("#851cfa"));
        }
        else if(senas.getCategoriaSenas().getIdCategoriaDB() == 6){
            tv_categoria.setBackgroundColor(Color.parseColor("#fc9af7"));
        }
        else{
            tv_categoria.setBackgroundColor(Color.parseColor("#99a49d"));
        }
    }

    public String getFileExtension(String filename){
        int rawId = Integer.parseInt(filename.substring(filename.lastIndexOf('/')+1));
        TypedValue value = new TypedValue();
        getResources().getValue(rawId,value,true);
        String[] s = value.string.toString().split("/");
        int rLength = s[s.length - 1].length();
        String extension = s[s.length - 1].substring(rLength-3, rLength);
        Log.i("filename", s[s.length - 1]);
        Log.i("extension", extension);
        return extension;

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mDetector.onTouchEvent(motionEvent);
        return true;
    }

    public class MyGestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            if (motionEvent.getX() < motionEvent1.getX()){
                actualIndexSena-=1;
                if (actualIndexSena < 0){
                    actualIndexSena = DiccionarioFragment.listaSenas.size()-1;
                }
                setSenaView(actualIndexSena);
            }
            if (motionEvent.getX() > motionEvent1.getX()){
                actualIndexSena+=1;
                if (actualIndexSena > DiccionarioFragment.listaSenas.size()-1){
                    actualIndexSena = 0;
                }
                setSenaView(actualIndexSena);
            }
            return true;
        }

        @Override
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public void onShowPress(MotionEvent motionEvent) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent motionEvent) {

        }
    }
}
