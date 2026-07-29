package Persistencia;

import Modelo.CategoriaGama;
import Modelo.Celular;
import Patrones.FactoryCelular;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CelularDAO {

    private ConexionDB conexion = new ConexionDB();

    public boolean registrar(Celular celular) {
        String sql = "INSERT INTO celulares "
                + "(marca, modelo, sistema_operativo, id_gama, precio, stock) "
                + "VALUES (?,?,?,?,?,?)";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setString(3, celular.getSistemaOperativo());
            ps.setInt(4, celular.getGama().getId());
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM celulares WHERE id = ?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizar(Celular celular) {
        String sql = "UPDATE celulares SET "
                + "marca=?, "
                + "modelo=?, "
                + "sistema_operativo=?, "
                + "id_gama=?, "
                + "precio=?, "
                + "stock=? "
                + "WHERE id=?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setString(3, celular.getSistemaOperativo());
            ps.setInt(4, celular.getGama().getId());
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());
            ps.setInt(7, celular.getId());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Celular> listarCelulares() {
        String sql = "SELECT * FROM celulares";
        List<Celular> celulares = new ArrayList<>();
        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {

            while (rs.next()) {
                Celular celular = FactoryCelular.crearCelular(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.fromId(rs.getInt("id_gama"))
                );
                celulares.add(celular);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return celulares;
    }

    public Celular buscarPorId(int id) {
        String sql = "SELECT * FROM celulares WHERE id = ?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Celular celular = FactoryCelular.crearCelular(
                            rs.getInt("id"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getDouble("precio"),
                            rs.getInt("stock"),
                            rs.getString("sistema_operativo"),
                            CategoriaGama.fromId(rs.getInt("id_gama"))
                    );
                    return celular;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarStock(int idCelular, int cantidad, Connection con) {

        String sql = """
            UPDATE celulares
            SET stock = stock - ?
            WHERE id = ?
             AND stock >= ?
            """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cantidad);
            ps.setInt(2, idCelular);
            ps.setInt(3, cantidad);

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
