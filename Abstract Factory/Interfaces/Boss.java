package Interfaces;

public interface Boss extends Enemigo {
    // Método para obtener el estado aplicable al jugador cuando el Jefe realiza un ataque especial
    EstadoJugador estadoAplicable();
    
    // Método para obtener la estrategia del Jefe
    Enemigo_Estrategia estrategia();
}
