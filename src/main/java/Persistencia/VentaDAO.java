package Persistencia;

import Modelo.Cliente;
import java.util.ArrayList;
import java.util.List;
import Modelo.DetalleVenta;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VentaDAO {

    private ConexionDB conexion = new ConexionDB();
    private DetalleVentaDAO detalleDAO = new DetalleVentaDAO();
    private CelularDAO celularDAO = new CelularDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();

    public boolean registrar(Venta venta) {

        String sql = """
                INSERT INTO ventas
                (id_cliente, fecha, total)
                VALUES (?, ?, ?)
                """;

        Connection con = null;

        try {

            con = conexion.conectar();

            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                ps.setInt(1, venta.getCliente().getId());
                ps.setDate(2, Date.valueOf(venta.getFecha()));
                ps.setDouble(3, venta.getTotal());

                int filas = ps.executeUpdate();

                if (filas == 0) {
                    throw new SQLException("No se pudo registrar la venta.");
                }

                try (ResultSet rs = ps.getGeneratedKeys()) {

                    if (rs.next()) {

                        int idVenta = rs.getInt(1);
                        venta.setId(idVenta);

                    } else {
                        throw new SQLException("No se obtuvo el ID de la venta.");
                    }
                }

                for (DetalleVenta detalle : venta.getDetalles()) {

                    detalle.setVenta(venta);

                    boolean registrado = detalleDAO.registrarDetalle(detalle, con);

                    if (!registrado) {
                        throw new SQLException("Error al registrar el detalle de la venta.");
                    }
                    boolean actualizado = celularDAO.actualizarStock(
                            detalle.getCelular().getId(),
                            detalle.getCantidad(),
                            con
                    );

                    if (!actualizado) {
                        throw new SQLException("No hay suficiente stock para realizar la venta.");
                    }
                }

                con.commit();

                return true;
            }
        } catch (SQLException e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
            return false;
        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    public List<Venta> listar() {

        List<Venta> ventas = new ArrayList<>();

        String sql = "SELECT * FROM ventas";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = clienteDAO.buscarPorId(rs.getInt("id_cliente"));

                Venta venta = new Venta(
                        rs.getInt("id"),
                        cliente,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("total")
                );

                venta.setDetalles(detalleDAO.listarPorVenta(venta));

                ventas.add(venta);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }
}
