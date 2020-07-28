package cl.sulcansystem.restaurante;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar, btnRegistrarse;
    TextView txtSlogan, txtBienvenido;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);

        txtBienvenido = (TextView) findViewById(R.id.txtBienvenido);
        txtSlogan = (TextView) findViewById(R.id.txtSlogan);
        Typeface face = Typeface.createFromAsset(getAssets(),"fuentes/SCRIPTBL.TTF");

        txtSlogan.setTypeface(face);
        txtBienvenido.setTypeface(face);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent ingresar = new Intent(MainActivity.this, Ingresar.class);
            startActivity(ingresar);
            finish();

            }
        });

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent registrarse = new Intent(MainActivity.this, Registrarse.class);
            startActivity(registrarse);
            finish();
            }
        });



    }
}