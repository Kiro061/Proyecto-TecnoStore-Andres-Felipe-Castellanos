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
        setCliente(cliente);
        this.fecha = LocalDate.now();
        this.detalles = new ArrayList<>();
    }

    public Venta(int id, Cliente cliente, LocalDate fecha, double total) {
        setId(id);
        setCliente(cliente);
        setFecha(fecha);
        setTotal(total);
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

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("La venta debe tener un cliente asociado.");
        }
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula.");
        }
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo.");
        }
        this.total = total;
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
