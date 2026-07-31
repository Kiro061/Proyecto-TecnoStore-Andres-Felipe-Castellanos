package Vista;

import Utilidades.Validador;

public class MenuPrincipal {

    private final VistaCelular vistaCelular = new VistaCelular();
    private final VistaCliente vistaCliente = new VistaCliente();
    private final VistaVenta vistaVenta = new VistaVenta();
    private final VistaReportes vistaReportes = new VistaReportes();

    private final Validador validador = new Validador();

    public void iniciar() {

        int opcion;

        do {

            opcion = validador.validarEnteroRango("""
                    
                    =================================
                            TECNOSTORE
                    =================================
                    1. Gestión de Celulares
                    2. Gestión de Clientes
                    3. Gestión de Ventas
                    4. Reportes
                    0. Salir
                    
                    Seleccione una opción:
                    """, 0, 4);

            switch (opcion) {

                case 1 ->
                    vistaCelular.mostrarMenu();

                case 2 ->
                    vistaCliente.mostrarMenu();

                case 3 ->
                    vistaVenta.mostrarMenu();

                case 4 ->
                    vistaReportes.mostrarMenu();

                case 0 ->
                    System.out.println("Gracias por usar TecnoStore.");

                default ->
                    System.out.println("Opción no válida.");

            }

        } while (opcion != 0);

    }

}