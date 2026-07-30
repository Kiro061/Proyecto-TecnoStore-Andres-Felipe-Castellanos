package Vista;

import Utilidades.ArchivoUtils;
import Utilidades.ReporteUtils;
import java.util.Scanner;

public class MenuPrincipal {

    private final Scanner sc = new Scanner(System.in);

    private final VistaCelular vistaCelular = new VistaCelular();
    private final VistaCliente vistaCliente = new VistaCliente();
    private final VistaVenta vistaVenta = new VistaVenta();
    private final VistaReportes vistaReportes = new VistaReportes();

    private final ReporteUtils reporte = new ReporteUtils();
    private final ArchivoUtils archivo = new ArchivoUtils();

    public void iniciar() {

        int opcion;

        do {

            System.out.println("""
                    
                    =================================
                            TECNOSTORE
                    =================================
                    1. Gestión de Celulares
                    2. Gestión de Clientes
                    3. Gestión de Ventas
                    4. Reportes
                    5. Generar reporte de ventas (.txt)
                    0. Salir
                    """);

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 ->
                    vistaCelular.mostrarMenu();

                case 2 ->
                    vistaCliente.mostrarMenu();

                case 3 ->
                    vistaVenta.mostrarMenu();

                case 4 ->
                    vistaReportes.mostrarMenu();

                case 5 ->
                    archivo.generarReporteVentas();

                case 0 ->
                    System.out.println("Gracias por usar TecnoStore.");

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }
}
