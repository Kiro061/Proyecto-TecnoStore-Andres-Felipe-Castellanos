
package Modelo;

public class Celular {
    private int id;
    private String marca;
    private String modelo;
    private double precio;
    private int stock;
    private String sistemaOperativo;
    private CategoriaGama gama;

    public Celular(int id, String marca, String modelo, double precio, int stock, String sistemaOperativo, CategoriaGama gama) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.stock = stock;
        this.sistemaOperativo = sistemaOperativo;
        this.gama = gama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio > 0){
           this.precio = precio; 
        } else {
            System.out.println("Error: el precio debe ser mayor que cero.");
        }        
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock>= 0){
            this.stock = stock;
        } else {
            System.out.println("Error: el stock no puede ser negativo.");
        }
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public CategoriaGama getGama() {
        return gama;
    }

    public void setGama(CategoriaGama gama) {
        this.gama = gama;
    }

    @Override
    public String toString() {
        return ("""
                ID:                 %s
                MARCA:              %s
                MODELO:             %s
                SISTEMA OPERATIVO:  %s
                GAMA:            %s
                PRECIO:             %s
                STOCK:              %s
                """.formatted(id,marca,modelo,sistemaOperativo,gama,precio,stock)); 
    }
    
    
}
