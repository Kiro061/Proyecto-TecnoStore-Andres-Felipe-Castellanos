package Controlador;

import Modelo.Celular;
import Persistencia.CelularDAO;
import java.util.List;

public class GestorCelulares {

    private CelularDAO celularDAO;

    public GestorCelulares() {
        celularDAO = new CelularDAO();
    }

    public boolean registrarCelular(Celular celular) {

        if (celular == null) {
            return false;
        }

        return celularDAO.registrar(celular);
    }

    public boolean actualizarCelular(Celular celular) {

        if (celular == null) {
            return false;
        }

        return celularDAO.actualizar(celular);
    }

    public boolean eliminarCelular(int id) {
        return celularDAO.eliminar(id);
    }

    public Celular buscarPorId(int id) {
        return celularDAO.buscarPorId(id);
    }

    public List<Celular> listarCelulares() {
        return celularDAO.listarCelulares();
    }

}
