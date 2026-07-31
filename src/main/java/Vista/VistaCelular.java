package Vista;

import Controlador.GestorCelulares;

import Modelo.CategoriaGama;
import Modelo.Celular;
import Patrones.FactoryCelular;
import Utilidades.Validador;

import java.util.List;

public class VistaCelular {

    private final GestorCelulares gestor = new GestorCelulares();
    private final Validador validador = new Validador();

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("""
                    
                    ===== GESTIÓN DE CELULARES =====
                    
                    1. Registrar celular
                    2. Buscar celular
                    3. Actualizar celular
                    4. Eliminar celular
                    5. Listar celulares
                    0. Volver
                    """);

            opcion = validador.validarEnteroRango(
                    "Seleccione una opción:",
                    0,
                    5
            );

            switch (opcion) {

                case 1 ->
                    registrarCelular();

                case 2 ->
                    buscarCelular();

                case 3 ->
                    actualizarCelular();

                case 4 ->
                    eliminarCelular();

                case 5 ->
                    listarCelulares();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");

            }

        } while (opcion != 0);

    }

    private void registrarCelular() {

        System.out.println("\n=== REGISTRAR CELULAR ===");

        String marca = validador.validarTexto("Marca:");
        String modelo = validador.validarTexto("Modelo:");
        double precio = validador.validarDecimal("Precio:");
        int stock = validador.validarEntero("Stock:");
        String sistema = validador.validarTexto("Sistema Operativo:");

        System.out.println("""
            Gama:
            1. Alta
            2. Media
            3. Baja
            """);

        int opcion = validador.validarEnteroRango("Seleccione la gama:", 1, 3);
        CategoriaGama gama = CategoriaGama.fromId(opcion);

        try {
            Celular celular = FactoryCelular.crearCelular(marca, modelo, precio, stock, sistema, gama);

            if (gestor.registrarCelular(celular)) {
                System.out.println("Celular registrado correctamente.");
            } else {
                System.out.println("No fue posible registrar el celular.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void buscarCelular() {

        int id = validador.validarEntero("ID del celular:");

        Celular celular = gestor.buscarPorId(id);

        if (celular != null) {
            System.out.println(celular);
        } else {
            System.out.println("Celular no encontrado.");
        }

    }

    private void actualizarCelular() {

        int id = validador.validarEntero("ID del celular:");

        Celular celular = gestor.buscarPorId(id);

        if (celular == null) {
            System.out.println("Celular no encontrado.");
            return;
        }

        String marca = validador.validarTexto("Marca:");
        String modelo = validador.validarTexto("Modelo:");
        double precio = validador.validarDecimal("Precio:");
        int stock = validador.validarEntero("Stock:");
        String sistema = validador.validarTexto("Sistema Operativo:");

        System.out.println("""
            Gama:
            1. Alta
            2. Media
            3. Baja
            """);

        int opcion = validador.validarEnteroRango("Seleccione la gama:", 1, 3);
        CategoriaGama gama = CategoriaGama.fromId(opcion);

        try {
            Celular actualizado = FactoryCelular.crearCelular(id, marca, modelo, precio, stock, sistema, gama);

            if (gestor.actualizarCelular(actualizado)) {
                System.out.println("Celular actualizado correctamente.");
            } else {
                System.out.println("No fue posible actualizar.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void eliminarCelular() {

        int id = validador.validarEntero("ID del celular:");

        if (gestor.eliminarCelular(id)) {
            System.out.println("Celular eliminado.");
        } else {
            System.out.println("No fue posible eliminar.");
        }

    }

    private void listarCelulares() {

        List<Celular> celulares = gestor.listarCelulares();

        if (celulares.isEmpty()) {
            System.out.println("No hay celulares registrados.");
            return;
        }

        celulares.forEach(System.out::println);

    }

}
