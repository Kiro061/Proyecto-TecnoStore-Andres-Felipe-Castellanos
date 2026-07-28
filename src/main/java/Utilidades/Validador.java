
package Utilidades;

import java.util.Scanner;


public class Validador {
    
        public int validarEntero(String mensaje) {
        int dato = 0;
        do {
            try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos.");
            }
        } while (dato < 1);
        return dato;
        }
        
        
        public int validarEnteroRango(String mensaje, int minimo, int maximo) {
        int dato = 0;
        do {
            try {
                System.out.println(mensaje);
                dato = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos.");
            }
        } while (dato < minimo || dato > maximo);
        return dato;
    }
}
