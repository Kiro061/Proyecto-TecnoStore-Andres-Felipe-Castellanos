package Vista;

import Controlador.GestorClientes;
import Modelo.Cliente;
import java.util.List;
import java.util.Scanner;

public class VistaCliente {

    private final Scanner sc = new Scanner(System.in);
    private final GestorClientes gestor = new GestorClientes();

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("""
                    
                    ===== GESTIÓN DE CLIENTES =====
                    
                    1. Registrar cliente
                    2. Buscar cliente
                    3. Actualizar cliente
                    4. Eliminar cliente
                    5. Listar clientes
                    0. Volver
                    """);

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 ->
                    registrarCliente();

                case 2 ->
                    buscarCliente();

                case 3 ->
                    actualizarCliente();

                case 4 ->
                    eliminarCliente();

                case 5 ->
                    listarClientes();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

    private void registrarCliente() {

        System.out.println("\n===== REGISTRAR CLIENTE =====");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Identificación: ");
        String identificacion = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Cliente cliente = new Cliente(
                nombre,
                identificacion,
                correo,
                telefono
        );

        if (gestor.registrarCliente(cliente)) {
            System.out.println("Cliente registrado correctamente.");
        } else {
            System.out.println("No fue posible registrar el cliente.");
        }

    }

    private void buscarCliente() {

        System.out.print("Ingrese el ID del cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        Cliente cliente = gestor.buscarCliente(id);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }

    }

    private void actualizarCliente() {

        System.out.print("Ingrese el ID del cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        Cliente cliente = gestor.buscarCliente(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Identificación: ");
        String identificacion = sc.nextLine();

        System.out.print("Correo: ");
        String correo = sc.nextLine();

        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();

        Cliente actualizado = new Cliente(
                id,
                nombre,
                identificacion,
                correo,
                telefono
        );

        if (gestor.actualizarCliente(actualizado)) {
            System.out.println("Cliente actualizado correctamente.");
        } else {
            System.out.println("No fue posible actualizar el cliente.");
        }

    }

    private void eliminarCliente() {

        System.out.print("Ingrese el ID del cliente: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (gestor.eliminarCliente(id)) {
            System.out.println("Cliente eliminado correctamente.");
        } else {
            System.out.println("No fue posible eliminar el cliente.");
        }

    }

    private void listarClientes() {

        List<Cliente> clientes = gestor.listarClientes();

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        clientes.forEach(System.out::println);

    }

}
