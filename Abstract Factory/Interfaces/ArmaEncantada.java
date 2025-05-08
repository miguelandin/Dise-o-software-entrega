package Interfaces;

public interface ArmaEncantada extends Enemigo {
    // Método para obtener el estado aplicable al jugador cuando la arma encantada realiza un ataque especial
    EstadoJugador estadoAplicable();
    
    // Método para obtener la estrategia de la arma encantada
    Enemigo_Estrategia estrategia();
}
