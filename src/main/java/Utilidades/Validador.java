package Utilidades;

import java.util.Scanner;

public class Validador {

    private final Scanner sc = new Scanner(System.in);

    public int validarEntero(String mensaje) {
        int dato = 0;
        boolean valido = false;
        do {
            System.out.println(mensaje);
            try {
                dato = sc.nextInt();
                sc.nextLine(); // consume el salto de línea pendiente
                valido = dato >= 1;
                if (!valido) {
                    System.out.println("Debe ingresar un número mayor o igual a 1.");
                }
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos. Debe ser un número.");
                sc.nextLine(); // limpia la entrada inválida
            }
        } while (!valido);
        return dato;
    }

    public double validarDecimal(String mensaje) {
        double dato = 0;
        boolean valido = false;
        do {
            System.out.println(mensaje);
            try {
                dato = sc.nextDouble();
                sc.nextLine(); // consume el salto de línea pendiente
                valido = dato >= 1;
                if (!valido) {
                    System.out.println("Debe ingresar un número mayor o igual a 1.");
                }
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos. Debe ser un número.");
                sc.nextLine(); // limpia la entrada inválida
            }
        } while (!valido);
        return dato;
    }

    public int validarEnteroRango(String mensaje, int minimo, int maximo) {
        int dato = 0;
        boolean valido = false;
        do {
            System.out.println(mensaje);
            try {
                dato = sc.nextInt();
                sc.nextLine(); // consume el salto de línea pendiente
                valido = dato >= minimo && dato <= maximo;
                if (!valido) {
                    System.out.println("Debe ingresar un número entre " + minimo + " y " + maximo + ".");
                }
            } catch (Exception e) {
                System.out.println("Error de ingreso de datos. Debe ser un número.");
                sc.nextLine(); // limpia la entrada inválida
            }
        } while (!valido);
        return dato;
    }

    public String validarTexto(String mensaje) {
        String dato;
        do {
            System.out.println(mensaje);
            dato = sc.nextLine();
        } while (dato == null || dato.isBlank());
        return dato;
    }
}
