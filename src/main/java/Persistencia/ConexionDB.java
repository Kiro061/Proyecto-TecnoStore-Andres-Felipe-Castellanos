
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    public Connection conectar(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyecto_TecnoStore", "root", "R00t_MySQL!2026");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}
