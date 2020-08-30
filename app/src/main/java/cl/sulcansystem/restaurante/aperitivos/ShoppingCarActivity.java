package cl.sulcansystem.restaurante.aperitivos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cl.sulcansystem.restaurante.R;
import cl.sulcansystem.restaurante.SingletonCar;
import cl.sulcansystem.restaurante.modelo.Productos;

public class ShoppingCarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Productos> productosList = new ArrayList<>();
    ShoppingCarAdapter productAdapter;

    Button makeRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shopping_car);

        recyclerView = findViewById(R.id.shopping_car);
        makeRequest = findViewById(R.id.button);

        productosList = SingletonCar.getInstance().getProductsList();

        productAdapter = new ShoppingCarAdapter(productosList);
        recyclerView.setAdapter(productAdapter);


        makeRequest.setOnClickListener(v -> {
            try {
                Uri uri = Uri.parse("smsto" + "+999");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.setPackage("com.whatsapp");
                startActivity(intent);
            } catch (Exception exc) {
                Toast.makeText(this, "Debes tener whatsapp instalado para poder hacer el pedido", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
