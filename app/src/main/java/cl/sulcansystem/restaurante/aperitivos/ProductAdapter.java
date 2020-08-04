package cl.sulcansystem.restaurante.aperitivos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.sulcansystem.restaurante.R;
import cl.sulcansystem.restaurante.modelo.Productos;
import timber.log.Timber;

class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ItemViewHolder> {

    private List<Productos> productos;

    ProductAdapter(List<Productos> pl) {
        this.productos = pl;
    }

    private static final int FAMILY = 0;
    private static final int PRODUCT = 1;

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate;
        switch (viewType) {
            case FAMILY:
                inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_family, parent, false);
                return new FamilyViewHolder(inflate);

            default:
                inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
                return new ProductViewHolder(inflate);
        }
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

    @Override
    public int getItemViewType(int position) {
        Productos producto = this.productos.get(position);
        if (isFamily(producto)) {
            // familia de productos
            return FAMILY;
        }
        return PRODUCT;
    }

    private boolean isFamily(Productos producto) {
        return producto.getDescripcion() != null && producto.getDescripcion().isEmpty() &&
                producto.getImagen() != null && producto.getImagen().isEmpty() &&
                producto.getPrecio() != null && producto.getPrecio().isEmpty();
    }

    public abstract class ItemViewHolder extends ViewHolder {
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        abstract void bind(Productos producto);
    }

    public class ProductViewHolder extends ItemViewHolder {

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
            if (producto.getDescripcion() != null) {
                title.setText(producto.getDescripcion());
            }
            price.setText("$ " + producto.getPrecio());

            try {
                Picasso.get().load(producto.getImagen()).resize(120, 120).centerCrop().into(imageView);
            } catch (Exception exc) {
                Timber.e(exc);
            }
        }
    }

    public class FamilyViewHolder extends ItemViewHolder {
        TextView name;

        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.family_name);
        }

        @Override
        void bind(Productos producto) {
            name.setText(producto.getNombre());
        }

    }
}
