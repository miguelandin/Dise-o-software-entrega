package Interfaces;

// Interfaz que representa un Murciélago, que es un tipo de enemigo
public interface Murcielago extends Enemigo {
    // Método para obtener el estado aplicable al jugador cuando el murciélago realiza un ataque especial
    EstadoJugador estadoAplicable();
    
    // Método para obtener la estrategia del murciélago
    Murcielago_Estrategia estrategia();
}
