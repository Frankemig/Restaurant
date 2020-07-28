package cl.sulcansystem.restaurante.tipos_usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cl.sulcansystem.restaurante.Ingresar;
import cl.sulcansystem.restaurante.R;

public class Administrador extends AppCompatActivity {
    String Nombre;
    TextView txt_usuarios, txt_productos, txt_procesos, txt_bartender, txt_cocina, txt_cajero, bienvenido_admin;
    ImageView usuarios, productos, procesos, bartender, cocina, cajero, bienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.administrador);

        Nombre = Ingresar.Nombre;
        txt_usuarios = (TextView) findViewById(R.id.txtusuarios_administrador);
        txt_productos = (TextView) findViewById(R.id.txtproductos);
        txt_procesos = (TextView) findViewById(R.id.txtprocesos);
        txt_bartender = (TextView) findViewById(R.id.txtvista_bartender);
        txt_cocina = (TextView) findViewById(R.id.txtvista_jefe_cocina);
        txt_cajero = (TextView) findViewById(R.id.txtvista_cajero);
        bienvenido_admin = (TextView) findViewById(R.id.txtBienvenido_administrador);

        Typeface face = Typeface.createFromAsset(getAssets(), "fuentes/SCRIPTBL.TTF");
        bienvenido_admin.setText("Bienvenido(a) " + Nombre);
        bienvenido_admin.setTypeface(face);
        txt_usuarios.setTypeface(face);
        txt_productos.setTypeface(face);
        txt_procesos.setTypeface(face);
        txt_bartender.setTypeface(face);
        txt_cocina.setTypeface(face);
        txt_cajero.setTypeface(face);

    }
}