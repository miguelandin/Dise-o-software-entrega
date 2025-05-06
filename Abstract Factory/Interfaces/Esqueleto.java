package Interfaces;

public interface Esqueleto extends Enemigo {
    // Método para obtener el estado aplicable al jugador cuando el esqueleto realiza un ataque especial
    EstadoJugador estadoAplicable();
    
    // Método para obtener la estrategia del esqueleto
    Enemigo_Estrategia estrategia();
}