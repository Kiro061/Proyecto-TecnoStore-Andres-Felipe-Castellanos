package Vista;

import Utilidades.ArchivoUtils;
import Utilidades.ReporteUtils;
import java.util.Scanner;

public class VistaReportes {

    private final Scanner sc = new Scanner(System.in);

    private final ReporteUtils reporte = new ReporteUtils();
    private final ArchivoUtils archivo = new ArchivoUtils();

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("""
                    
                    ===== REPORTES =====
                    
                    1. Celulares con stock bajo
                    2. Top 3 celulares más vendidos
                    3. Ventas totales por mes
                    4. Generar reporte de ventas (.txt)
                    0. Volver
                    """);

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {

                case 1 ->
                    reporte.mostrarStockBajo();

                case 2 ->
                    reporte.mostrarTop3Vendidos();

                case 3 ->
                    reporte.mostrarVentasPorMes();

                case 4 ->
                    archivo.generarReporteVentas();

                case 0 ->
                    System.out.println("Volviendo al menú principal...");

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

}
