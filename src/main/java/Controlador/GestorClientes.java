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

        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            return false;
        }

        if (cliente.getCorreo() == null || cliente.getCorreo().trim().isEmpty()) {
            return false;
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            return false;
        }

        return clienteDAO.registrar(cliente);
    }

    public boolean actualizarCliente(Cliente cliente) {

        if (cliente == null) {
            return false;
        }

        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            return false;
        }

        if (cliente.getCorreo() == null || cliente.getCorreo().trim().isEmpty()) {
            return false;
        }

        if (cliente.getTelefono() == null || cliente.getTelefono().trim().isEmpty()) {
            return false;
        }

        return clienteDAO.actualizar(cliente);
    }

    public boolean eliminarCliente(int identificacion) {
        return clienteDAO.eliminar(identificacion);
    }

    public Cliente buscarCliente(int identificacion) {
        return clienteDAO.buscarPorId(identificacion);
    }

    public List<Cliente> listarClientes() {
        return clienteDAO.listar();
    }

}
