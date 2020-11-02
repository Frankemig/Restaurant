package cl.sulcansystem.restaurante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import cl.sulcansystem.restaurante.modelo.BaseDatosEmpleados;
import cl.sulcansystem.restaurante.modelo.Empleado;
import cl.sulcansystem.restaurante.modelo.Evento;
import cl.sulcansystem.restaurante.tipos_usuarios.PublicoGeneral;

public class QuienesSomos extends AppCompatActivity {

BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quienes_somos);

        showSelectedFragment(new NuestroEquipo());

bottomNavigationView = findViewById(R.id.buttonNavigation);

bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId()==R.id.nuestro_equipo){
            showSelectedFragment(new NuestroEquipo());

        }else if (item.getItemId()==R.id.restaurant){
            showSelectedFragment(new Restaurant());

        }else if (item.getItemId()==R.id.eventos){
            showSelectedFragment(new EventosVista());
        }

        return true;
    }
});

    }
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    @Override
    public void onBackPressed() {
        Intent publico = new Intent(QuienesSomos.this, PublicoGeneral.class);
        startActivity(publico);
        finish();
        super.onBackPressed();
    }
}