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

    public boolean registrarCelular(Celular celular) {
        String sql = "INSERT INTO celulares "
                + "(marca, modelo, sistema_operativo, gama, precio, stock) "
                + "VALUES (?,?,?,?,?,?)";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setString(3, celular.getSistemaOperativo());
            ps.setString(4, celular.getGama().toString());
            ps.setDouble(5, celular.getPrecio());
            ps.setInt(6, celular.getStock());

            int filas = ps.executeUpdate();

            return filas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCelular(int id) {
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

    public boolean actualizarCelular(Celular celular) {
        String sql = "UPDATE celulares SET "
                + "marca=?, "
                + "modelo=?, "
                + "sistema_operativo=?, "
                + "gama=?, "
                + "precio=?, "
                + "stock=? "
                + "WHERE id=?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, celular.getMarca());
            ps.setString(2, celular.getModelo());
            ps.setString(3, celular.getSistemaOperativo());
            ps.setString(4, celular.getGama().toString());
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

    public List<Celular> listarCelular() {
        String sql = "SELECT * FROM celulares";
        List<Celular> celulares = new ArrayList<>();
        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Celular celular = FactoryCelular.crearCelular(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.valueOf(rs.getString("gama"))
                );
                celulares.add(celular);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return celulares;
    }

    public Celular buscarPorIdCelular(int id) {
        String sql = "SELECT * FROM celulares WHERE id = ?";

        try (Connection con = conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Celular celular = FactoryCelular.crearCelular(
                        rs.getInt("id"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getDouble("precio"),
                        rs.getInt("stock"),
                        rs.getString("sistema_operativo"),
                        CategoriaGama.valueOf(rs.getString("gama"))
                );
                return celular;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
