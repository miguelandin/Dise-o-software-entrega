package Interfaces;

// Enumeración que define los diferentes mundos disponibles en el juego
public enum Mundos {
    // Enumerados para cada uno de los mundos con su respectiva dificultad y nombre
    BOSQUE(1, "BOSQUE"),
    TUNDRA(2, "TUNDRA"),
    VOLCAN(3, "VOLCAN");

    // Atributos finales para la dificultad y el nombre de cada mundo
    private final int dificultad;
    private final String nombre;

    // Constructor privado para inicializar los atributos de cada mundo
    Mundos(int dificultad, String nombre) {
        this.dificultad = dificultad;
        this.nombre = nombre;
    }
   
    // Método getter para obtener la dificultad del mundo
    public int getDificultad() {
        return dificultad;
    }
    
    // Método getter para obtener el nombre del mundo
    public String getNombre() {
        return nombre;
    }
}
