package cl.sulcansystem.restaurante.modelo;

public class Productos {
    private String Nombre, Descripcion, Precio, Imagen;

    public Productos() {
    }

    public Productos(String nombre, String descripcion, String precio, String imagen) {
        Nombre = nombre;
        Descripcion = descripcion;
        Precio = precio;
        Imagen = imagen;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "Nombre='" + Nombre + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", Precio='" + Precio + '\'' +
                ", Imagen='" + Imagen + '\'' +
                '}';
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String precio) {
        Precio = precio;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
