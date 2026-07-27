

package Principal;

import Persistencia.ConexionDB;


public class Main {

    public static void main(String[] args) {
        ConexionDB c = new ConexionDB();
       c.conectar();
        System.out.println("Conexion Exitosa");
    }
}
