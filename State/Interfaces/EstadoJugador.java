package Interfaces;

// La interfaz EstadoJugador define los métodos que deben ser implementados por los diferentes estados del jugador
public interface EstadoJugador {
    String nombreEstado(); // Método para obtener el nombre del estado
    int danioEstado(); // Método para obtener el daño causado por el estado
    int numTurnos(); // Método para obtener el número de turnos restantes para este estado
    void reducirTurnos(); // Método para reducir en 1 el número de turnos restantes para este estado
}
