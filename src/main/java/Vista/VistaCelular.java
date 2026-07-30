package Vista;

import Controlador.GestorCelulares;
import Modelo.CategoriaGama;
import Modelo.Celular;
import Patrones.FactoryCelular;

import java.util.List;
import java.util.Scanner;

public class VistaCelular {

    private final Scanner sc = new Scanner(System.in);
    private final GestorCelulares gestor = new GestorCelulares();

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

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

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

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

    private void registrarCelular() {

        System.out.println("\n=== REGISTRAR CELULAR ===");

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        System.out.print("Sistema Operativo: ");
        String sistema = sc.nextLine();

        System.out.println("""
                Gama:
                1. Alta
                2. Media
                3. Baja
                """);

        int opcion = sc.nextInt();

        CategoriaGama gama = CategoriaGama.fromId(opcion);

        Celular celular = FactoryCelular.crearCelular(
                marca,
                modelo,
                precio,
                stock,
                sistema,
                gama
        );

        if (gestor.registrarCelular(celular)) {
            System.out.println("Celular registrado correctamente.");
        } else {
            System.out.println("No fue posible registrar el celular.");
        }

    }

    private void buscarCelular() {

        System.out.print("ID del celular: ");
        int id = sc.nextInt();

        Celular celular = gestor.buscarCelular(id);

        if (celular != null) {
            System.out.println(celular);
        } else {
            System.out.println("Celular no encontrado.");
        }

    }

    private void actualizarCelular() {

        System.out.print("ID del celular: ");
        int id = sc.nextInt();
        sc.nextLine();

        Celular celular = gestor.buscarCelular(id);

        if (celular == null) {
            System.out.println("Celular no encontrado.");
            return;
        }

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        System.out.print("Stock: ");
        int stock = sc.nextInt();
        sc.nextLine();

        System.out.print("Sistema Operativo: ");
        String sistema = sc.nextLine();

        System.out.println("""
                Gama:
                1. Alta
                2. Media
                3. Baja
                """);

        int opcion = sc.nextInt();

        CategoriaGama gama = CategoriaGama.fromId(opcion);

        Celular actualizado = FactoryCelular.crearCelular(
                id,
                marca,
                modelo,
                precio,
                stock,
                sistema,
                gama
        );

        if (gestor.actualizarCelular(actualizado)) {
            System.out.println("Celular actualizado correctamente.");
        } else {
            System.out.println("No fue posible actualizar.");
        }

    }

    private void eliminarCelular() {

        System.out.print("ID del celular: ");
        int id = sc.nextInt();

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
