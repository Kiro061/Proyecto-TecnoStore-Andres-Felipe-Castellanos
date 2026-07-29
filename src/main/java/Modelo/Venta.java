package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int id;
    private Cliente cliente;
    private LocalDate fecha;
    private double total;
    private List<DetalleVenta> detalles;

    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.fecha = LocalDate.now();
        this.detalles = new ArrayList<>();
    }

    public Venta(int id, Cliente cliente, LocalDate fecha, double total) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.total = total;
        this.detalles = new ArrayList<>();
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {

        total = 0;

        for (DetalleVenta detalle : detalles) {
            total += detalle.getSubtotal();
        }

        return total;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return """
                ID:      %s
                CLIENTE: %s
                FECHA:   %s
                TOTAL:   %.2f
                """.formatted(
                id,
                cliente.getNombre(),
                fecha,
                total
        );
    }
}
