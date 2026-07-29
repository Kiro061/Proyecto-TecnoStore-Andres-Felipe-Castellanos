package Modelo;

public enum CategoriaGama {

    ALTA(1),
    MEDIA(2),
    BAJA(3);

    private final int id;

    CategoriaGama(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static CategoriaGama fromId(int id) {
        for (CategoriaGama gama : values()) {
            if (gama.getId() == id) {
                return gama;
            }
        }
        throw new IllegalArgumentException("Id de categoría inválido: " + id);
    }
}