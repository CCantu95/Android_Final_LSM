/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal.Random3;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import itesm.mx.javafinal.MainActivity;
import itesm.mx.javafinal.R;
import itesm.mx.javafinal.Random10.Juego_hamburguesa;
import itesm.mx.javafinal.Random11.Juego_k;
import itesm.mx.javafinal.Random2.Juego_cebolla_corr;
import itesm.mx.javafinal.Random4.Juego_pizza_corr;
import itesm.mx.javafinal.Random5.Juego_amiga_corr;
import itesm.mx.javafinal.Random6.Juego_conejo_corr;
import itesm.mx.javafinal.Random7.Juego_vibora;
import itesm.mx.javafinal.Random8.Juego_uva;
import itesm.mx.javafinal.Random9.Juego_arroz;
import itesm.mx.javafinal.juegoaleatorio.Juego_febrero_corr;


public class Juego_hongo_corr extends AppCompatActivity {
    android.widget.VideoView VideoView;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_hongo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.titulo_aleatorio));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        VideoView = (android.widget.VideoView) findViewById(R.id.VideoView);
        uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hongo);
        VideoView.setMediaController((new MediaController(this)));
        VideoView.setVideoURI(uri);
        VideoView.requestFocus();
        VideoView.start();

        VideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                VideoView.start();
            }
        });


        //Cambiar el boton correcto por el otro

        final Button button_b = (Button) findViewById(R.id.button_b);
        final Button button_c = (Button) findViewById(R.id.button_c);
        final Button button_d = (Button) findViewById(R.id.button_a);
        TextView pagina = (TextView) findViewById(R.id.textViewPagina);
        pagina.setText("8/10");
        //Botones falso
        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_b.setBackgroundColor(Color.RED);
                final Toast toast2 = Toast.makeText(getApplicationContext(), "Respuesta Incorrecta", Toast.LENGTH_SHORT);
                toast2.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast2.cancel();
                    }
                }, 1200);


            }
        });
        button_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_c.setBackgroundColor(Color.RED);
                final Toast toast3 = Toast.makeText(getApplicationContext(), "Respuesta Incorrecta", Toast.LENGTH_SHORT);
                toast3.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast3.cancel();
                    }
                }, 1200);


            }
        });
        button_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_d.setBackgroundColor(Color.RED);
                final Toast toast4 = Toast.makeText(getApplicationContext(), "Respuesta Incorrecta", Toast.LENGTH_SHORT);
                toast4.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast4.cancel();
                    }
                }, 1200);


            }
        });
        final Button button_corr = (Button) findViewById(R.id.button_d);
        button_corr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_corr.setBackgroundColor(Color.GREEN);
                final Toast toast1 = Toast.makeText(getApplicationContext(), "Respuesta Correcta", Toast.LENGTH_SHORT);
                toast1.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast1.cancel();
                    }
                }, 1200);
                int numero = (int) (Math.random() * 11) + 1;

                if (numero == 1) {
                    Intent o = new Intent(getApplicationContext(), Juego_febrero_corr.class);
                    startActivity(o);
                } else if (numero == 2) {
                    Intent o = new Intent(getApplicationContext(), Juego_cebolla_corr.class);
                    startActivity(o);
                } else if (numero == 3) {
                    Intent o = new Intent(getApplicationContext(), Juego_jueves_corr.class);
                    startActivity(o);

                } else if (numero == 4) {
                    Intent o = new Intent(getApplicationContext(), Juego_pizza_corr.class);
                    startActivity(o);
                } else if (numero == 5) {
                    Intent o = new Intent(getApplicationContext(), Juego_amiga_corr.class);
                    startActivity(o);
                } else if (numero == 6) {
                    Intent o = new Intent(getApplicationContext(), Juego_conejo_corr.class);
                    startActivity(o);

                } else if (numero == 7) {
                    Intent o = new Intent(getApplicationContext(), Juego_vibora.class);
                    startActivity(o);

                } else if (numero == 8) {
                    Intent o = new Intent(getApplicationContext(), Juego_uva.class);
                    startActivity(o);

                } else if (numero == 9) {
                    Intent o = new Intent(getApplicationContext(), Juego_arroz.class);
                    startActivity(o);

                } else if (numero == 10) {
                    Intent o = new Intent(getApplicationContext(), Juego_hamburguesa.class);
                    startActivity(o);

                } else {
                    Intent o = new Intent(getApplicationContext(), Juego_k.class);
                    startActivity(o);

                }

            }
        });


    }@Override     public void onResume(){         super.onResume();         VideoView.start();     }      @Override     public void onPause(){         super.onPause();     }     @Override     public boolean onSupportNavigateUp() {         onBackPressed();          return true;     }

    @Override
    public void onBackPressed() {
        Intent o = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(o);
    }
}
