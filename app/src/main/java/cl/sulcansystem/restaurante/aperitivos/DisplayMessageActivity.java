package cl.sulcansystem.restaurante.aperitivos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.sulcansystem.restaurante.R;
import cl.sulcansystem.restaurante.modelo.Productos;
import timber.log.Timber;

public class DisplayMessageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Productos> productosList = new ArrayList<>();
    ProductAdapter productAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_cocteles_casa);

        recyclerView = findViewById(R.id.recyclerAperitivos);

        productAdapter = new ProductAdapter(productosList);
        recyclerView.setAdapter(productAdapter);

        loadData();
    }

    private void loadData() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Timber.d("onDataChange() called");

                //Map<String, List<Productos>> arbolProductos = new HashMap<>();
                snapshot.child("Aperitivos").getChildren().forEach(dataSnapshot -> {

                    List<Productos> productos = new ArrayList<>();
                    productos.add(new Productos(getName(dataSnapshot.getKey()), "", "", ""));
                    dataSnapshot.getChildren().forEach(dataSnapshot2 -> {
                        productos.add(dataSnapshot2.getValue(Productos.class));
                    });

                    productosList.addAll(productos);

                });


                //arbolProductos.forEach((s, productos) -> Timber.d(s + " - " + productos));

                //productosList.addAll(arbolProductos.get("Piscos_y_Sour´s"));
                //Timber.d("productosList - size: " + productosList.size());
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    /**
     * Esto es un parche horrible pero necesario en este momento
     * @param key
     * @return
     */
    private String getName(String key) {
        switch (key) {
            case "Clasicos": return "Clásicos";
            case "Piscos_y_Sour's": return "Piscos y sour's";
            default:
                return key;
        }
    }
}
