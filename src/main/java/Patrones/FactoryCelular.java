package Patrones;

import Modelo.CategoriaGama;
import Modelo.Celular;

public class FactoryCelular {

    private FactoryCelular() {
    }

    // Para registrar
    public static Celular crearCelular(
            String marca,
            String modelo,
            double precio,
            int stock,
            String sistemaOperativo,
            CategoriaGama gama) {

        return new Celular(
                marca,
                modelo,
                precio,
                stock,
                sistemaOperativo,
                gama
        );
    }

    // Para actualizar o buscar
    public static Celular crearCelular(
            int id,
            String marca,
            String modelo,
            double precio,
            int stock,
            String sistemaOperativo,
            CategoriaGama gama) {

        return new Celular(
                id,
                marca,
                modelo,
                precio,
                stock,
                sistemaOperativo,
                gama
        );
    }
}