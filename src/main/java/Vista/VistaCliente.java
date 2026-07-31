package Vista;

import Controlador.GestorClientes;
import Modelo.Cliente;
import Utilidades.Validador;

import java.util.List;

public class VistaCliente {

    private final GestorClientes gestor = new GestorClientes();
    private final Validador validador = new Validador();

    public void mostrarMenu() {

        int opcion;

        do {

            opcion = validador.validarEnteroRango("""
                    
                    ===== GESTIÓN DE CLIENTES =====
                    
                    1. Registrar cliente
                    2. Buscar cliente
                    3. Actualizar cliente
                    4. Eliminar cliente
                    5. Listar clientes
                    0. Volver
                    
                    Seleccione una opción:
                    """, 0, 5);

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

            }

        } while (opcion != 0);

    }

    private void registrarCliente() {

        System.out.println("\n===== REGISTRAR CLIENTE =====");

        String nombre = validador.validarTexto("Nombre:");
        String identificacion = validador.validarTexto("Identificación:");
        String correo = validador.validarTexto("Correo:");
        String telefono = validador.validarTexto("Teléfono:");

        try {
            Cliente cliente = new Cliente(nombre, identificacion, correo, telefono);

            if (gestor.registrarCliente(cliente)) {
                System.out.println("Cliente registrado correctamente.");
            } else {
                System.out.println("No fue posible registrar el cliente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void buscarCliente() {

        int id = validador.validarEntero("Ingrese el ID del cliente:");

        Cliente cliente = gestor.buscarCliente(id);

        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente no encontrado.");
        }

    }

    private void actualizarCliente() {

        int id = validador.validarEntero("Ingrese el ID del cliente:");

        Cliente cliente = gestor.buscarCliente(id);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        String nombre = validador.validarTexto("Nombre:");
        String identificacion = validador.validarTexto("Identificación:");
        String correo = validador.validarTexto("Correo:");
        String telefono = validador.validarTexto("Teléfono:");

        try {
            Cliente actualizado = new Cliente(id, nombre, identificacion, correo, telefono);

            if (gestor.actualizarCliente(actualizado)) {
                System.out.println("Cliente actualizado correctamente.");
            } else {
                System.out.println("No fue posible actualizar el cliente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private void eliminarCliente() {

        int id = validador.validarEntero("Ingrese el ID del cliente:");

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
