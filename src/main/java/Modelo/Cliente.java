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
        if (id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor que cero.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación no puede estar vacía.");
        }
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.isBlank() || !correo.contains("@")) {
            throw new IllegalArgumentException("El correo no es válido.");
        }
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono;
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
