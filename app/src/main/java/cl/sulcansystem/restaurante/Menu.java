package cl.sulcansystem.restaurante;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import cl.sulcansystem.restaurante.aperitivos.DisplayMessageActivity;
import cl.sulcansystem.restaurante.aperitivos.ShoppingCarActivity;
import cl.sulcansystem.restaurante.tipos_usuarios.PublicoGeneral;

public class Menu extends AppCompatActivity {

    private static final String TAG = "Menu";

    TextView txt_aperitivos, txt_bebestibles, txt_vinos, txt_entradas, txt_fondos, txt_postres, menu;
    ImageView aperitivos, bebestibles, vinos, entradas, fondos, postres, logo, whatsapp;


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
        whatsapp = findViewById(R.id.bt_whatsapp);

        Typeface face = Typeface.createFromAsset(getAssets(), "fuentes/scrip.ttf");
        menu.setTypeface(face);
        txt_aperitivos.setTypeface(face);
        txt_bebestibles.setTypeface(face);
        txt_vinos.setTypeface(face);
        txt_entradas.setTypeface(face);
        txt_fondos.setTypeface(face);
        txt_postres.setTypeface(face);

        aperitivos.setOnClickListener(view -> {
            Log.d(TAG, "onClick: aperitivos");
            start("Aperitivos");
        });

        bebestibles.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Jugos_y_Bebidas");
            start("Jugos_y_Bebidas");
        });

        vinos.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Vinos");
            start("Vinos");
        });

        entradas.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Entradas");
            start("Entradas");
        });

        fondos.setOnClickListener(view -> {
            Log.d(TAG, "onClick: Fondos");
            start("Fondos");
        });

        postres.setOnClickListener(view -> {
            //Aquí se Debe Inflar el Fragmento Postres
            Log.d(TAG, "onClick: Postres_y_Cafés");
            start("Postres_y_Cafés");
        });

        whatsapp.setOnClickListener(view -> {
            Log.d(TAG, "whastapp");

            Intent intent = new Intent(this, ShoppingCarActivity.class);
            startActivity(intent);

        });

    }

    private void start(String target) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("TARGET", target);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent publico = new Intent(Menu.this, PublicoGeneral.class);
        startActivity(publico);
        finish();
        super.onBackPressed();
    }
}