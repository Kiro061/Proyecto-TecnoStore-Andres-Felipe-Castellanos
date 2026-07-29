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
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Error: el ID debe ser mayor que cero.");
        }
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        if (venta != null) {
            this.venta = venta;
        } else {
            System.out.println("Error: la venta no puede ser nula.");
        }
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        if (celular != null) {
            this.celular = celular;
        } else {
            System.out.println("Error: el celular no puede ser nulo.");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad > 0) {
            this.cantidad = cantidad;
        } else {
            System.out.println("Error: la cantidad debe ser mayor que cero.");
        }
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        if (subtotal >= 0) {
            this.subtotal = subtotal;
        } else {
            System.out.println("Error: el subtotal no puede ser negativo.");
        }
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
