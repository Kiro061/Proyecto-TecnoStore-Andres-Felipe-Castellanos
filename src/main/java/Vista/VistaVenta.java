package Vista;

import Controlador.GestorVentas;
import Modelo.Celular;
import Modelo.Cliente;
import Modelo.DetalleVenta;
import Modelo.Venta;
import Persistencia.CelularDAO;
import Persistencia.ClienteDAO;

import java.util.Scanner;

public class VistaVenta {

    private final Scanner sc = new Scanner(System.in);

    private final GestorVentas gestor = new GestorVentas();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final CelularDAO celularDAO = new CelularDAO();

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("""
                    
                    ===== GESTIÓN DE VENTAS =====
                    
                    1. Registrar venta
                    0. Volver
                    """);

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1 ->
                    registrarVenta();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

    private void registrarVenta() {

        System.out.println("\n===== REGISTRAR VENTA =====");

        System.out.print("Identificación del cliente: ");
        String identificacion = sc.nextLine();

        Cliente cliente = clienteDAO.buscarPorIdentificacion(identificacion);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        Venta venta = new Venta(cliente);

        int continuar;
        
        do {
            System.out.println("\n===== CELULARES DISPONIBLES =====");
            celularDAO.listarCelulares().forEach(System.out::println);
            
            System.out.print("ID del celular: ");
            int idCelular = sc.nextInt();

            Celular celular = celularDAO.buscarPorId(idCelular);

            if (celular == null) {
                System.out.println("Celular no encontrado.");
                return;
            }

            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();

            double subtotal = celular.getPrecio() * cantidad;

            DetalleVenta detalle = new DetalleVenta(
                    venta,
                    celular,
                    cantidad,
                    subtotal
            );

            venta.agregarDetalle(detalle);

            System.out.println("""
                    
                    ¿Desea agregar otro celular?
                    
                    1. Sí
                    2. No
                    """);

            continuar = sc.nextInt();

        } while (continuar == 1);

        if (gestor.registrarVenta(venta)) {

            System.out.println("Venta registrada correctamente.");
            System.out.println("Total con IVA: $" + venta.getTotal());

        } else {

            System.out.println("No fue posible registrar la venta.");

        }

    }

}
