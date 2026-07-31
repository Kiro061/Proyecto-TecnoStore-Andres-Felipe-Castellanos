package Controlador;

import Modelo.Celular;
import Modelo.Venta;
import Persistencia.CelularDAO;
import Persistencia.VentaDAO;
import java.util.List;

public class GestorReportes {

    private final CelularDAO celularDAO;
    private final VentaDAO ventaDAO;

    public GestorReportes() {
        this.celularDAO = new CelularDAO();
        this.ventaDAO = new VentaDAO();
    }

    public List<Celular> listarCelulares() {
        return celularDAO.listarCelulares();
    }

    public List<Venta> listarVentas() {
        return ventaDAO.listar();
    }

}
