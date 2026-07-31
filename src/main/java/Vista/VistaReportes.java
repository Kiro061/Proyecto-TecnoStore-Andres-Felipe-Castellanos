package Vista;

import Utilidades.ArchivoUtils;
import Utilidades.ReporteUtils;
import Utilidades.Validador;

public class VistaReportes {

    private final ReporteUtils reporte = new ReporteUtils();
    private final ArchivoUtils archivo = new ArchivoUtils();
    private final Validador validador = new Validador();

    public void mostrarMenu() {

        int opcion;

        do {

            opcion = validador.validarEnteroRango("""
                    
                    ===== REPORTES =====
                    
                    1. Celulares con stock bajo
                    2. Top 3 celulares más vendidos
                    3. Ventas totales por mes
                    4. Generar reporte de ventas (.txt)
                    0. Volver
                    
                    Seleccione una opción:
                    """, 0, 4);

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

            }

        } while (opcion != 0);

    }

}
