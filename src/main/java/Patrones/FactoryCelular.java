package Patrones;

import Modelo.CategoriaGama;
import Modelo.Celular;

public class FactoryCelular {

    public static Celular crearCelular(
            int id,
            String marca,
            String modelo,
            double precio,
            int stock,
            String sistemaOperativo,
            CategoriaGama gama) {

        return new Celular(id,marca,modelo,precio,stock,sistemaOperativo,gama);
    }
}
