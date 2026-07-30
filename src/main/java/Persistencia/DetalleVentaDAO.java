package Persistencia;

import Modelo.DetalleVenta;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DetalleVentaDAO {

    private ConexionDB conexion = new ConexionDB();
    private CelularDAO celularDAO = new CelularDAO();

    public boolean registrarDetalle(DetalleVenta detalle, Connection con) {

        String sql = """
                INSERT INTO detalle_ventas
                (id_venta, id_celular, cantidad, subtotal)
                VALUES (?, ?, ?, ?)
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, detalle.getVenta().getId());
            ps.setInt(2, detalle.getCelular().getId());
            ps.setInt(3, detalle.getCantidad());
            ps.setDouble(4, detalle.getSubtotal());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<DetalleVenta> listarPorVenta(Venta venta) {

        List<DetalleVenta> detalles = new ArrayList<>();

        String sql = "SELECT * FROM detalle_ventas WHERE id_venta = ?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, venta.getId());

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    DetalleVenta detalle = new DetalleVenta(
                            rs.getInt("id"),
                            venta,
                            celularDAO.buscarPorId(rs.getInt("id_celular")),
                            rs.getInt("cantidad"),
                            rs.getDouble("subtotal")
                    );

                    detalles.add(detalle);
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detalles;
    }
}
