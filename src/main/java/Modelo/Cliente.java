package Modelo;

public class Cliente {

    private int id;
    private String nombre;
    private String identificacion;
    private String correo;
    private String telefono;

    public Cliente(String nombre, String identificacion, String correo, String telefono) {
        setNombre(nombre);
        setIdentificacion(identificacion);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public Cliente(int id, String nombre, String identificacion, String correo, String telefono) {
        setId(id);
        setNombre(nombre);
        setIdentificacion(identificacion);
        setCorreo(correo);
        setTelefono(telefono);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Error: el ID debe ser mayor que cero.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: el nombre no puede estar vacío.");
        }
    }

    public String getIdentificacion() {
        return identificacion;
    }


    public void setIdentificacion(String identificacion) {
        if (identificacion != null && !identificacion.isBlank()) {
            this.identificacion = identificacion;
        } else {
            System.out.println("Error: la identificación no puede estar vacía.");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo != null && !correo.isBlank() && correo.contains("@")) {
            this.correo = correo;
        } else {
            System.out.println("Error: el correo no es válido.");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.isBlank()) {
            this.telefono = telefono;
        } else {
            System.out.println("Error: el teléfono no puede estar vacío.");
        }
    }

    @Override
    public String toString() {
        return ("""
                ID:                 %d
                NOMBRE:             %s
                IDENTIFICACION:     %s
                CORREO:             %s
                TELEFONO:           %s
                """.formatted(id, nombre, identificacion, correo, telefono));
    }

}
