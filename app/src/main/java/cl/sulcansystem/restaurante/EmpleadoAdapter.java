package cl.sulcansystem.restaurante;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cl.sulcansystem.restaurante.modelo.Empleado;
import de.hdodenhof.circleimageview.CircleImageView;
import timber.log.Timber;

class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {

private List<Empleado>listaEmpleados;

    public EmpleadoAdapter(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empleado,parent,false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {
        Empleado empleado = listaEmpleados.get(position);
        holder.bind(empleado);

    }

    @Override
    public int getItemCount() {
        return listaEmpleados.size();
    }

    public class EmpleadoViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoEmpleado;
        private TextView titulo_item_empleado, nombre_empleado, descripcion_empleado;

        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo_item_empleado = itemView.findViewById(R.id.titulo_item_empleado);
            nombre_empleado = itemView.findViewById(R.id.nombre_empleado);
            descripcion_empleado = itemView.findViewById(R.id.descripcion_empleado);
            fotoEmpleado = itemView.findViewById(R.id.foto_empleado);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
        public void bind(Empleado empleado) {
            Timber.d("bind() called with: empleado = [" + empleado + "]");
            titulo_item_empleado.setText(empleado.getPuesto());
            if (empleado.getDescripcion() != null) {
                descripcion_empleado.setText(empleado.getDescripcion());
            }
            nombre_empleado.setText(empleado.getNombre());

            try {
                Picasso.get()
                        .load(empleado.getImagenEmpleado())
                        .resize(150, 200)
                        .placeholder(R.drawable.ic_idea_comodin)
                        .centerCrop()
                        .into(fotoEmpleado);
            } catch (Exception exc) {
                Timber.e(exc);
            }

        }

    }

}
