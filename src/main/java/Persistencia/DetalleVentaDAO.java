package Persistencia;

import Modelo.DetalleVenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DetalleVentaDAO {

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
}