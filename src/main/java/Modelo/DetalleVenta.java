package Modelo;

public class DetalleVenta {

    private int id;
    private Venta venta;
    private Celular celular;
    private int cantidad;
    private double subtotal;

    public DetalleVenta(Venta venta, Celular celular, int cantidad, double subtotal) {
        setVenta(venta);
        setCelular(celular);
        setCantidad(cantidad);
        setSubtotal(subtotal);
    }

    public DetalleVenta(int id, Venta venta, Celular celular, int cantidad, double subtotal) {
        setId(id);
        setVenta(venta);
        setCelular(celular);
        setCantidad(cantidad);
        setSubtotal(subtotal);
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        if (venta == null) {
            throw new IllegalArgumentException("La venta no puede ser nula.");
        }
        this.venta = venta;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        if (celular == null) {
            throw new IllegalArgumentException("El celular no puede ser nulo.");
        }
        this.celular = celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo.");
        }
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return ("""
                ID:         %s
                ID VENTA:   %s
                ID CELULAR: %s
                CANTIDAD:   %s
                SUBTOTAL:   %.2f
                """.formatted(id, venta.getId(), celular.getId(), cantidad, subtotal));
    }
}
