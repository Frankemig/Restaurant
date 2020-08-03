package cl.sulcansystem.restaurante;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cl.sulcansystem.restaurante.aperitivos.DisplayMessageActivity;

public class Menu extends AppCompatActivity {

    private static final String TAG = "Menu";

    TextView txt_aperitivos, txt_bebestibles, txt_vinos, txt_entradas, txt_fondos, txt_postres, menu;
    ImageView aperitivos, bebestibles, vinos, entradas, fondos, postres, logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = (TextView)findViewById(R.id.menu);
        txt_aperitivos = (TextView)findViewById(R.id.txt_aperitivo);
        txt_bebestibles = (TextView)findViewById(R.id.txt_bebestibles);
        txt_vinos = (TextView)findViewById(R.id.txt_vinos);
        txt_entradas = (TextView)findViewById(R.id.txt_entradas);
        txt_fondos = (TextView)findViewById(R.id.txt_fondos);
        txt_postres = (TextView)findViewById(R.id.txt_postres);
        aperitivos = (ImageView)findViewById(R.id.aperitivo);
        bebestibles = (ImageView)findViewById(R.id.jugos_bebidas);
        vinos = (ImageView)findViewById(R.id.vinos);
        entradas = (ImageView)findViewById(R.id.entradas);
        fondos = (ImageView)findViewById(R.id.fondos);
        postres = (ImageView)findViewById(R.id.postres);
        logo = (ImageView)findViewById(R.id.logo_pie);

        Typeface face = Typeface.createFromAsset(getAssets(),"fuentes/SCRIPTBL.TTF");
        menu.setTypeface(face);
        txt_aperitivos.setTypeface(face);
        txt_bebestibles.setTypeface(face);
        txt_vinos.setTypeface(face);
        txt_entradas.setTypeface(face);
        txt_fondos.setTypeface(face);
        txt_postres.setTypeface(face);

        aperitivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: aperitivos");

                start();
            }
        });

        bebestibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí se Debe Inflar el Fragmento Bebestibles
            }
        });

        vinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí se Debe Inflar el Fragmento Vinos
            }
        });

        entradas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí se Debe Inflar el Fragmento Entradas
            }
        });

        fondos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí se Debe Inflar el Fragmento Fondos
            }
        });

        postres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aquí se Debe Inflar el Fragmento Postres
            }
        });
    }

    private void start() {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent main = new Intent(Menu.this,MainActivity.class);
        startActivity(main);
        finish();
        super.onBackPressed();
    }
}