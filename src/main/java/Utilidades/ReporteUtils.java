package Utilidades;

import Controlador.GestorReportes;
import Modelo.DetalleVenta;
import Modelo.Venta;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteUtils {

    private final GestorReportes gestor = new GestorReportes();

    // ============================
    // REPORTE 1
    // ============================
    public void mostrarStockBajo() {
        System.out.println("\n===== CELULARES CON STOCK MENOR A 5 =====");
        gestor.listarCelulares()
                .stream()
                .filter(c -> c.getStock() < 5)
                .forEach(System.out::println);
    }

    // ============================
    // REPORTE 2
    // ============================
    public void mostrarTop3Vendidos() {
        System.out.println("\n===== TOP 3 CELULARES MÁS VENDIDOS =====");
        List<Venta> ventas = gestor.listarVentas();
        Map<String, Integer> vendidos = new HashMap<>();

        for (Venta venta : ventas) {
            for (DetalleVenta detalle : venta.getDetalles()) {
                String nombre = detalle.getCelular().getMarca()
                        + " "
                        + detalle.getCelular().getModelo();
                vendidos.put(
                        nombre,
                        vendidos.getOrDefault(nombre, 0)
                        + detalle.getCantidad()
                );
            }
        }

        vendidos.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(e -> System.out.println(
                e.getKey() + " -> " + e.getValue() + " unidades"
        ));
    }

    // ============================
    // REPORTE 3
    // ============================
    public void mostrarVentasPorMes() {
        System.out.println("\n===== VENTAS TOTALES POR MES =====");
        List<Venta> ventas = gestor.listarVentas();
        Map<Month, Double> totalMes = new HashMap<>();

        for (Venta venta : ventas) {
            Month mes = venta.getFecha().getMonth();
            totalMes.put(
                    mes,
                    totalMes.getOrDefault(mes, 0.0)
                    + venta.getTotal()
            );
        }

        totalMes.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println(
                e.getKey() + " : $" + e.getValue()
        ));
    }
}
