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
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameActivity extends Fragment implements View.OnClickListener {
    TextView tipo, pa;
    Button b_UNO, b_DOS, b_TRES, b_CUATRO;
    String respuesta;
    //public static ArrayList<Integer> UsedNumbers = new ArrayList<>();
    public static ArrayList<Senas> ListaSenas = new ArrayList<>() ;
    int ganar = 0, pos = 0;
    final Handler handler = new Handler();
    String fullPath, ext;
    VideoView video;
    ImageView ima;
    private static final int delay = 1200;

    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.activity_game,vg,false);
        tipo = (TextView) rootView.findViewById(R.id.tipo);
        b_UNO = (Button) rootView.findViewById(R.id.UNO);
        b_DOS = (Button) rootView.findViewById(R.id.DOS);
        b_TRES = (Button) rootView.findViewById(R.id.TRES);
        b_CUATRO = (Button) rootView.findViewById(R.id.CUATRO);
        b_UNO.setOnClickListener(this);
        b_DOS.setOnClickListener(this);
        b_TRES.setOnClickListener(this);
        b_CUATRO.setOnClickListener(this);

        video = rootView.findViewById(R.id.vv_V);
        ima = rootView.findViewById(R.id.iv_Foto);


        video.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                video.start();
            }
        });

        fullPath = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/";

        pa = (TextView) rootView.findViewById(R.id.pa);
        pa.setText(String.valueOf(pos)+"/15");

        refresh();

        return rootView;
    }

    public void refresh()
    {
        Collections.shuffle(ListaSenas);

        tipo.setText(ListaSenas.get(0).getNombreSena().toString());
        b_UNO.setText((ListaSenas.get(randomNumber()).getNombreSena()).toString());
        b_DOS.setText((ListaSenas.get(randomNumber()).getNombreSena()).toString());
        b_TRES.setText((ListaSenas.get(randomNumber()).getNombreSena()).toString());
        b_CUATRO.setText((ListaSenas.get(randomNumber()).getNombreSena()).toString());



        fullPath = fullPath + ListaSenas.get(0).getResourceSena();
        ext = getFileExtension(fullPath);

        if(ext.equals("JPG"))
        {
            video.setVisibility(View.GONE);
            ima.setVisibility(View.VISIBLE);
            ima.setImageResource(ListaSenas.get(0).getResourceSena());
        }else
        {
            video.setVisibility(View.VISIBLE);
            ima.setVisibility(View.GONE);
            video.setVideoURI(Uri.parse(fullPath));
            video.start();
        }



        fullPath = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/";
        ext = "";

        b_UNO.getBackground().setColorFilter(Color.parseColor("#02cdfb"), PorterDuff.Mode.MULTIPLY);
        b_DOS.getBackground().setColorFilter(Color.parseColor("#02cdfb"), PorterDuff.Mode.MULTIPLY);
        b_TRES.getBackground().setColorFilter(Color.parseColor("#02cdfb"), PorterDuff.Mode.MULTIPLY);
        b_CUATRO.getBackground().setColorFilter(Color.parseColor("#02cdfb"), PorterDuff.Mode.MULTIPLY);


        pos++;
        pa.setText(String.valueOf(pos)+"/15");

        Collections.shuffle(ListaSenas);


        //respuesta = ListaSenas.get(1).getNombreSena();
        Random respuesta = new Random();
        int i = respuesta.nextInt(4);
        switch(i)
        {
            case 0:
                b_UNO.setText(tipo.getText().toString());
                break;
            case 1:
                b_DOS.setText(tipo.getText().toString());
                break;
            case 2:
                b_TRES.setText(tipo.getText().toString());
                break;
            case 3:
                b_CUATRO.setText(tipo.getText().toString());
                break;
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
    public void onResume(){
        super.onResume();
        video.start();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    public void fin()
    {
        if(ganar == 15)
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();

            int displaymode = getResources().getConfiguration().orientation;
            if(displaymode == 1){// portrait
                Final O1 = new Final();
                fragmentTransaction.replace(android.R.id.content,O1);
            }else {// landscape
                //Main2 f2 = new Main2();
                //fragmentTransaction.replace(android.R.id.content,f2);
            }
            fragmentTransaction.commit();
        }
    }

    public int randomNumber()
    {
        Random generator = new Random();
        boolean existe = false;
        int i = generator.nextInt(ListaSenas.size());


        return i;
    }
    @Override
    public void onClick(View view) {

        switch(view.getId())
        {
            case R.id.UNO:

                if(tipo.getText().toString().equals(b_UNO.getText().toString()))
                {
                    //b_UNO.setBackgroundColor(Color.GREEN);
                    b_UNO.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta correcta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ganar++;

                            refresh();

                            fin();

                        }
                    }, 100);
                }else
                {
                    b_UNO.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta incorrecta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                }
                break;

            case R.id.DOS:


                if(tipo.getText().toString().equals(b_DOS.getText().toString()))
                {
                    //b_DOS.setBackgroundColor(Color.GREEN);
                    b_DOS.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta correcta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ganar++;

                            refresh();

                            fin();

                        }
                    }, 100);
                }else
                {
                    b_DOS.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta incorrecta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                }
                break;

            case R.id.TRES:


                if(tipo.getText().toString().equals(b_TRES.getText().toString()))
                {
                    //b_TRES.setBackgroundColor(Color.GREEN);
                    b_TRES.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta correcta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ganar++;

                            refresh();

                            fin();

                        }
                    }, 100);
                }else
                {
                    b_TRES.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);

                    final Toast toast = Toast.makeText(getActivity(), "Respuesta incorrecta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                }
                break;

            case R.id.CUATRO:



                if(tipo.getText().toString().equals(b_CUATRO.getText().toString()))
                {
                    //b_CUATRO.setBackgroundColor(Color.GREEN);
                    b_CUATRO.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.MULTIPLY);
                    final Toast toast = Toast.makeText(getActivity(), "Respuesta correcta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ganar++;

                            refresh();

                            fin();

                        }
                    }, 100);
                }else
                {
                    b_CUATRO.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.MULTIPLY);

                    final Toast toast = Toast.makeText(getActivity(), "Respuesta incorrecta!",
                            Toast.LENGTH_LONG);
                    toast.show();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1200);
                }
                break;
        }
    }
}
