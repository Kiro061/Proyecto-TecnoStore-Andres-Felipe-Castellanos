package Vista;

import Controlador.GestorVentas;
import Modelo.Celular;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Venta;
import Controlador.GestorCelulares;
import Controlador.GestorClientes;
import Utilidades.Validador;

public class VistaVenta {

    private final GestorVentas gestor = new GestorVentas();
    private final GestorClientes gestorClientes = new GestorClientes();
    private final GestorCelulares gestorCelulares = new GestorCelulares();
    private final Validador validador = new Validador();

    public void mostrarMenu() {

        int opcion;

        do {

            opcion = validador.validarEnteroRango("""
                    
                    ===== GESTIÓN DE VENTAS =====
                    
                    1. Registrar venta
                    0. Volver
                    
                    Seleccione una opción:
                    """, 0, 1);

            switch (opcion) {

                case 1 ->
                    registrarVenta();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");

            }

        } while (opcion != 0);

    }

    private void registrarVenta() {

        System.out.println("\n===== REGISTRAR VENTA =====");

        String identificacion = validador.validarTexto("Identificación del cliente:");

        Cliente cliente = gestorClientes.buscarPorIdentificacion(identificacion);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Venta venta;

        try {
            venta = new Venta(cliente);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        int continuar;

        do {

            System.out.println("\n===== CELULARES DISPONIBLES =====");
            gestorCelulares.listarCelulares().forEach(System.out::println);

            int idCelular = validador.validarEntero("ID del celular:");
            Celular celular = gestorCelulares.buscarPorId(idCelular);

            if (celular == null) {
                System.out.println("Celular no encontrado.");
                return;
            }

            int cantidad = validador.validarEntero("Cantidad:");
            double subtotal = celular.getPrecio() * cantidad;

            try {
                DetalleVenta detalle = new DetalleVenta(venta, celular, cantidad, subtotal);
                venta.agregarDetalle(detalle);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }

            continuar = validador.validarEnteroRango("""
            
            ¿Desea agregar otro celular?
            
            1. Sí
            2. No
            
            Seleccione una opción:
            """, 1, 2);

        } while (continuar == 1);

        if (gestor.registrarVenta(venta)) {
            System.out.println("Venta registrada correctamente.");
            System.out.printf("Total con IVA: $%,.2f%n", venta.getTotal());
        } else {
            System.out.println("No fue posible registrar la venta.");
        }

    }
}
