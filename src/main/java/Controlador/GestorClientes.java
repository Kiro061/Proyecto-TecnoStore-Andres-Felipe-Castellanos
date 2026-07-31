package Controlador;

import Modelo.Cliente;
import Persistencia.ClienteDAO;
import java.util.List;

public class GestorClientes {

    private final ClienteDAO clienteDAO;

    public GestorClientes() {
        this.clienteDAO = new ClienteDAO();
    }

    public boolean registrarCliente(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        return clienteDAO.registrar(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clienteDAO.eliminar(id);
    }

    public Cliente buscarCliente(int id) {
        return clienteDAO.buscarPorId(id);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

    public Cliente buscarPorIdentificacion(String identificacion) {
        return clienteDAO.buscarPorIdentificacion(identificacion);
    }

}