package Modelo;

public class Celular {

    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String sistemaOperativo;
    private CategoriaGama gama;

    public Celular(String marca, String modelo, double precio,int stock, String sistemaOperativo, CategoriaGama gama) {

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
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Error: el ID debe ser mayor que cero.");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca != null && !marca.isBlank()) {
            this.marca = marca;
        } else {
            System.out.println("Error: la marca no puede estar vacía.");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo != null && !modelo.isBlank()) {
            this.modelo = modelo;
        } else {
            System.out.println("Error: el modelo no puede estar vacío.");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0) {
            this.precio = precio;
        } else {
            System.out.println("Error: el precio debe ser mayor que cero.");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            System.out.println("Error: el stock no puede ser negativo.");
        }
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        if (sistemaOperativo != null && !sistemaOperativo.isBlank()) {
            this.sistemaOperativo = sistemaOperativo;
        } else {
            System.out.println("Error: el sistema operativo no puede estar vacío.");
        }
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public void setGama(CategoriaGama gama) {
        if (gama != null) {
            this.gama = gama;
        } else {
            System.out.println("Error: debe seleccionar una gama.");
        }
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
