
package Vista;


public class VistaCliente {
    public void MenuClientes() {
        Validaciones v= new Validaciones();
        int op;
        do {
            op = v.validarEnteroRango("""
                                      Bienvenido a la Gestion Clientes
                                      Digite la opcion a escoger:
                                      1.Registrar Nuevo Cliente.
                                      2.Listar Clientes.
                                      3.Actualizar Clientes.
                                      4.Eliminar Clientes.
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

