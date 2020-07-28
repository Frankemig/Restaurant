package cl.sulcansystem.restaurante.tipos_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cl.sulcansystem.restaurante.Ingresar;
import cl.sulcansystem.restaurante.Menu;
import cl.sulcansystem.restaurante.R;

public class PublicoGeneral extends AppCompatActivity {

    ImageView reservas, delivery, quienes_somos, contactanos, logoSulcan;
    TextView txtBienvenido, txtNombreUsuario, txtReserva, txtDelivery, txtQuienesSomos, txtContactanos;

public static String txtUsuario = Ingresar.Nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.publico_general);

        txtNombreUsuario = (TextView)findViewById(R.id.nombreUsuario);
        txtNombreUsuario.setText(txtUsuario);
        reservas = (ImageView)findViewById(R.id.reservas);
        delivery = (ImageView)findViewById(R.id.delivery);
        quienes_somos = (ImageView)findViewById(R.id.quienes_somos);
        contactanos = (ImageView)findViewById(R.id.contactanos);
        logoSulcan = (ImageView)findViewById(R.id.icon_logo_sulcan);
        txtBienvenido = (TextView)findViewById(R.id.bienvenidos);
        txtReserva = (TextView)findViewById(R.id.txtreservar);
        txtDelivery = (TextView)findViewById(R.id.txtdelivery);
        txtQuienesSomos = (TextView)findViewById(R.id.txtquienes_somos);
        txtContactanos = (TextView)findViewById(R.id.txtcontactanos);

        Typeface face = Typeface.createFromAsset(getAssets(),"fuentes/SCRIPTBL.TTF");
        txtBienvenido.setTypeface(face);
        txtNombreUsuario.setTypeface(face);
        txtContactanos.setTypeface(face);
        txtQuienesSomos.setTypeface(face);
        txtDelivery.setTypeface(face);
        txtReserva.setTypeface(face);

        reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PublicoGeneral.this, "Estás Entrando a Reservas", Toast.LENGTH_SHORT).show();
            }
        });

        delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent menu = new Intent(PublicoGeneral.this, Menu.class);
                startActivity(menu);
                finish();
            }
        });

        quienes_somos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PublicoGeneral.this, "Estás Entrando a Quienes Somos", Toast.LENGTH_SHORT).show();
            }
        });

        contactanos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(PublicoGeneral.this, "Estás Entrando a Contáctanos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}