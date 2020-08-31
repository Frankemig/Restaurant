package cl.sulcansystem.restaurante.modelo;

import java.util.ArrayList;
import java.util.List;

public class LocalesDataBase {
    public static List<Local>listaLocales = new ArrayList<>();

    public LocalesDataBase() {
    }
    public static List<Local> getListaLocales() {
        return listaLocales;
    }

    public static void setListaLocales(List<Local> listaLocales) {
        LocalesDataBase.listaLocales = listaLocales;
    }
    static {
        int id = 0;
        listaLocales.add(new Local(id++,"'Bien Taypá' - Restaurante Peruano y Chifa","Sierra Bella N° 1501", "Gastronomía Abis Alex Zavaleta León EIRL","76.905.471-5","225516570","+56948120976", "+569 58737826"));
    }
}
