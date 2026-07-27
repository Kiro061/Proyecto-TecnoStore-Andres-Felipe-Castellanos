
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionDB {
    public Connection conectar(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Proyecto_TecnoStore", "campus2023", "campus2023");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return c;
    }
}
