package cl.sulcansystem.restaurante.modelo;

public class Local {
    private int id;
    private String nombreEmpresa, direccionEmpresa,razonSocial, rutEmpresa, telefonoFijo, whatsappLocal, whatsappGerente;

    public Local() {
    }

    public Local(int id, String nombreEmpresa, String direccionEmpresa, String razonSocial, String rutEmpresa, String telefonoFijo, String whatsappLocal, String whatsappGerente) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.razonSocial = razonSocial;
        this.rutEmpresa = rutEmpresa;
        this.telefonoFijo = telefonoFijo;
        this.whatsappLocal = whatsappLocal;
        this.whatsappGerente = whatsappGerente;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", direccionEmpresa='" + direccionEmpresa + '\'' +
                ", razonSocial='" + razonSocial + '\'' +
                ", rutEmpresa='" + rutEmpresa + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", whatsappLocal='" + whatsappLocal + '\'' +
                ", whatsappGerente='" + whatsappGerente + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getWhatsappLocal() {
        return whatsappLocal;
    }

    public void setWhatsappLocal(String whatsappLocal) {
        this.whatsappLocal = whatsappLocal;
    }

    public String getWhatsappGerente() {
        return whatsappGerente;
    }

    public void setWhatsappGerente(String whatsappGerente) {
        this.whatsappGerente = whatsappGerente;
    }
}
