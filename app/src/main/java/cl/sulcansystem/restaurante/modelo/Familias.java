package cl.sulcansystem.restaurante.modelo;

import java.util.List;
import java.util.Map;

public class Familias {
    private Map<String, Map<String, List<String>>> message;

    public Familias() {
    }

    public Familias(Map<String, Map<String, List<String>>> message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Familias{" +
                "message=" + message +
                '}';
    }

    public Map<String, Map<String, List<String>>> getMessage() {
        return message;
    }

    public void setMessage(Map<String, Map<String, List<String>>> message) {
        this.message = message;
    }
}
