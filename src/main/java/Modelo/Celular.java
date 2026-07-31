package Modelo;

public class Celular {

    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String sistemaOperativo;
    private CategoriaGama gama;

    public Celular(String marca, String modelo, double precio, int stock, String sistemaOperativo, CategoriaGama gama) {
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setStock(stock);
        setSistemaOperativo(sistemaOperativo);
        setGama(gama);
    }

    public Celular(int id, String marca, String modelo, double precio, int stock, String sistemaOperativo, CategoriaGama gama) {
        setId(id);
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setStock(stock);
        setSistemaOperativo(sistemaOperativo);
        setGama(gama);
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacía.");
        }
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío.");
        }
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        if (sistemaOperativo == null || sistemaOperativo.isBlank()) {
            throw new IllegalArgumentException("El sistema operativo no puede estar vacío.");
        }
        this.sistemaOperativo = sistemaOperativo;
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public void setGama(CategoriaGama gama) {
        if (gama == null) {
            throw new IllegalArgumentException("Debe seleccionar una gama.");
        }
        this.gama = gama;
    }

    @Override
    public String toString() {
        return ("""
                ID:                 %d
                MARCA:              %s
                MODELO:             %s
                SISTEMA OPERATIVO:  %s
                GAMA:               %s
                PRECIO:             %.2f
                STOCK:              %d
                """.formatted(id, marca, modelo, sistemaOperativo, gama, precio, stock));
    }
}
