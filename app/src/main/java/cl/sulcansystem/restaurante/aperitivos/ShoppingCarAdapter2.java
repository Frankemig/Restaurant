package cl.sulcansystem.restaurante.aperitivos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.sulcansystem.restaurante.R;
import cl.sulcansystem.restaurante.SingletonCar;
import cl.sulcansystem.restaurante.modelo.Productos;
import timber.log.Timber;

class ShoppingCarAdapter2 extends RecyclerView.Adapter<ShoppingCarAdapter2.ItemViewHolder> {

    private List<Productos> productos;

    ShoppingCarAdapter2(List<Productos> pl) {
        this.productos = pl;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carrito2, parent, false);
        return new ItemViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Productos producto = this.productos.get(position);
        holder.bind(producto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView cantidad;
        TextView textId;
        TextView price;
        ImageView car;
        ImageView carAdd;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            cantidad = itemView.findViewById(R.id.tvCantidad);
            textId = itemView.findViewById(R.id.tvId);
            price = itemView.findViewById(R.id.tvPrecio);
            car = itemView.findViewById(R.id.ivCar);
            carAdd = itemView.findViewById(R.id.ivCarAdd);
        }

        public void bind(Productos producto) {
            Timber.d("bind() called with: producto = [" + producto + "]");
            textId.setText(producto.getNombre());

            price.setText("$ " + producto.getPrecio());

            cantidad.setText("1");

            car.setOnClickListener(view -> {
                SingletonCar.getInstance().remove(producto);
                Toast.makeText(car.getContext(), "Se eliminó " + producto.getNombre() + " del carrito", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            });

            carAdd.setOnClickListener(view -> {
                SingletonCar.getInstance().add(producto);
                Toast.makeText(car.getContext(), "Se agregó " + producto.getNombre() + " al carrito", Toast.LENGTH_LONG).show();
                notifyDataSetChanged();
            });
        }
    }
}

