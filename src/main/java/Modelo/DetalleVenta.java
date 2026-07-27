
package Modelo;


public class DetalleVenta {
    private int id;
    private Venta venta;
    private Celular celular;
    private int cantidad;
    private double subtotal;

    public DetalleVenta(int id, Venta venta, Celular celular, int cantidad, double subtotal) {
        this.id = id;
        this.venta = venta;
        this.celular = celular;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(Celular celular) {
        this.celular = celular;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public String toString() {
        return ("""
                ID:         %s
                ID VENTA:   %s
                ID CELULAR: %s
                CANTIDAD:   %s
                SUBTOTAL:   %s
                """.formatted(id,venta,celular,cantidad,subtotal));
    }
    
    
            
            
}
