package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Proyecto_TecnoStore",
                "root",
                "R00t_MySQL!2026"
        );
    }

}