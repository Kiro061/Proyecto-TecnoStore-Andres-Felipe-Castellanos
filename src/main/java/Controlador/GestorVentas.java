package Controlador;

import Modelo.Celular;
import Modelo.DetalleVenta;
import Modelo.Venta;
import Persistencia.CelularDAO;
import Persistencia.ClienteDAO;
import Persistencia.VentaDAO;

public class GestorVentas {

    private final VentaDAO ventaDAO;
    private final ClienteDAO clienteDAO;
    private final CelularDAO celularDAO;

    private static final double IVA = 0.19;

    public GestorVentas() {
        this.ventaDAO = new VentaDAO();
        this.clienteDAO = new ClienteDAO();
        this.celularDAO = new CelularDAO();
    }

    public boolean registrarVenta(Venta venta) {

        if (venta == null) {
            return false;
        }

        if (venta.getCliente() == null) {
            return false;
        }

        if (clienteDAO.buscarPorId(venta.getCliente().getId()) == null) {
            return false;
        }

        if (venta.getDetalles() == null || venta.getDetalles().isEmpty()) {
            return false;
        }

        double subtotal = 0;

        for (DetalleVenta detalle : venta.getDetalles()) {

            if (detalle == null) {
                return false;
            }

            Celular celular = celularDAO.buscarPorId(detalle.getCelular().getId());

            if (celular == null) {
                return false;
            }

            if (detalle.getCantidad() <= 0) {
                return false;
            }

            if (celular.getStock() < detalle.getCantidad()) {
                return false;
            }

            subtotal += celular.getPrecio() * detalle.getCantidad();
        }

        double total = subtotal + (subtotal * IVA);

        venta.setTotal(total);

        return ventaDAO.registrar(venta);
    }

}