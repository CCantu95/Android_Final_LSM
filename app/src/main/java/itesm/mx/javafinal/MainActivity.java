/*
Copyright.© Instituto Tecnológico y de Estudios Superiores de Monterrey, México, 2016.
Nombre: Lengua de Señas Mexicana
Año: 2017
Descripción:
"Lengua de Señas Mexicana" es una aplicación que permite aprender la lengua de señas mexicana a través de un diccionario y un juego.
Por: Jorge Ávalos, César Alán Cantú, Jordi Rodriguez
*/

package itesm.mx.javafinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import itesm.mx.javafinal.Random10.Juego_azul;
import itesm.mx.javafinal.Random11.Juego_25;
import itesm.mx.javafinal.Random2.Juego_b_corr;
import itesm.mx.javafinal.Random3.Juego_Aguacate_corr;
import itesm.mx.javafinal.Random4.Juego_nieto_corr;
import itesm.mx.javafinal.Random5.Juego_pastel_corr;
import itesm.mx.javafinal.Random6.Juego_nopal_corr;
import itesm.mx.javafinal.Random7.Juego_chocolate_corr;
import itesm.mx.javafinal.Random8.Juego_verde;
import itesm.mx.javafinal.Random9.Juego_abuela;
import itesm.mx.javafinal.juegoaleatorio.Juego_a_corr;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_titulo;
    Button btn_diccionario, btn_juego, btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.text_titulo));

        tv_titulo = (TextView)findViewById(R.id.text_titulo);

        btn_diccionario = (Button)findViewById(R.id.button_diccionario);
        btn_juego = (Button)findViewById(R.id.button_juego);
        btn_test = (Button)findViewById(R.id.button_test);

        btn_diccionario.setOnClickListener(this);
        btn_juego.setOnClickListener(this);
        btn_test.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_diccionario:
                Intent intent = new Intent(getApplicationContext(),DiccionarioActivity.class);
                startActivity(intent);
                break;
            case R.id.button_juego:
                Intent intent2 = new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(intent2);
                break;
            case R.id.button_test:
                int numero = (int) (Math.random() *11) + 1;


                if (numero==1) {
                    Intent o = new Intent(getApplicationContext(), Juego_a_corr.class);
                    startActivity(o);
                }
                else if (numero==2){
                    Intent o = new Intent(getApplicationContext(), Juego_b_corr.class);
                    startActivity(o);
                }
                else if (numero==3){
                    Intent o = new Intent(getApplicationContext(), Juego_Aguacate_corr.class);
                    startActivity(o);

                }
                else if (numero==4) {
                    Intent o = new Intent(getApplicationContext(), Juego_nieto_corr.class);
                    startActivity(o);
                }
                else if (numero==5){
                    Intent o = new Intent(getApplicationContext(), Juego_pastel_corr.class);
                    startActivity(o);
                }
                else if (numero==6){
                    Intent o = new Intent(getApplicationContext(), Juego_nopal_corr.class);
                    startActivity(o);

                }
                else if (numero==7) {
                    Intent o = new Intent(getApplicationContext(), Juego_chocolate_corr.class);
                    startActivity(o);

                }
                else if (numero==8) {
                    Intent o = new Intent(getApplicationContext(), Juego_verde.class);
                    startActivity(o);

                }
                else if (numero==9) {
                    Intent o = new Intent(getApplicationContext(), Juego_abuela.class);
                    startActivity(o);

                }
                else if (numero==10) {
                    Intent o = new Intent(getApplicationContext(), Juego_azul.class);
                    startActivity(o);

                }
                else{
                    Intent o = new Intent(getApplicationContext(), Juego_25.class);
                    startActivity(o);

                }

                break;
        }


    }
    @Override
    public void onBackPressed() {
        finishAffinity();

    }
}
