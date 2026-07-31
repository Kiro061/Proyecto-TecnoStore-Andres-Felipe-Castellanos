package Utilidades;

import Controlador.GestorReportes;
import Modelo.Venta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivoUtils {

    private final GestorReportes gestor = new GestorReportes();

    public void generarReporteVentas() {
        List<Venta> ventas = gestor.listarVentas();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("reporte_ventas.txt"))) {
            bw.write("===== REPORTE DE VENTAS =====");
            bw.newLine();
            bw.newLine();

            for (Venta venta : ventas) {
                bw.write("Venta #" + venta.getId());
                bw.newLine();
                bw.write("Cliente: " + venta.getCliente().getNombre());
                bw.newLine();
                bw.write("Fecha: " + venta.getFecha());
                bw.newLine();
                bw.write(String.format("Total: $%,.2f", venta.getTotal()));
                bw.newLine();
                bw.write("--------------------------------");
                bw.newLine();
            }

            System.out.println("Reporte generado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al generar el reporte.");
        }
    }
}