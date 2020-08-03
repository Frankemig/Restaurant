package cl.sulcansystem.restaurante.aperitivos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.sulcansystem.restaurante.R;
import cl.sulcansystem.restaurante.modelo.Productos;
import timber.log.Timber;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>
{

    private List<Productos> productos;

    ProductAdapter(List<Productos> pl){
        this.productos = pl;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ProductViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Productos producto = this.productos.get(position);
        holder.bind(producto);
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView textId;
        ImageView imageView;
        TextView price;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txTitle);
            textId = itemView.findViewById(R.id.tvId);
            price = itemView.findViewById(R.id.tvPrecio);
            imageView = itemView.findViewById(R.id.imageViewAvatar);
        }

        public void bind(Productos producto) {
            Timber.d("bind() called with: producto = [" + producto + "]");
            textId.setText(producto.getNombre());
            if(producto.getDescripcion() != null) {
                title.setText(producto.getDescripcion());
            }
            price.setText("$ " + producto.getPrecio());

            try {
                Picasso.get().load(producto.getImagen()).resize(120, 120).centerCrop().into(imageView);
            }catch (Exception exc) {
                Timber.e(exc);
            }
        }
    }
}
