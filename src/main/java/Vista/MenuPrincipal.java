
package Vista;
import Utilidades.Validador;

public class MenuPrincipal {
    
    public void Menu() {
        Validador v= new Validador();
        int op;
        do {
            op = v.validarEnteroRango("""
                                      Bienvenido a TecnoStore
                                      Digite la opcion a escoger:
                                      1.Gestion Celulares
                                      2.Gestion Clientes
                                      3.Gestion Ventas
                                      4.Reportes y Estadisticas
                                      5.Salir
                                      """,1,5);
            switch (op){
                case 1:
                    
                case 2:
                    
                case 3:
                    
                case 4:
                    
                case 5:
                    System.out.println("Gracias por usar nuestra aplicacion.");
                    break;
            }
        } while (op != 5);
    }
}
