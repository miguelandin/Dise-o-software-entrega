package Estados;

import java.util.Random;

import Interfaces.EstadoJugador;

// La clase EstadoNormal implementa el estado de jugador "Normal"
public class EstadoNormal implements EstadoJugador {
    Random random = new Random(); // Objeto Random para generar números aleatorios
    private int num_turnos = 0; // Número de turnos para este estado (siempre 0 para Normal)

    // Método para obtener el nombre del estado
    @Override
    public String nombreEstado() {
        return "Normal";
    }

    // Método para obtener el daño causado por este estado (siempre 0 para Normal)
    @Override
    public int danioEstado() {
        return 0;
    }

    // Método para obtener el número de turnos restantes para este estado (siempre 0 para Normal)
    @Override
    public int numTurnos() {
        return 0;
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "EstadoNormal [nombreEstado()=" + nombreEstado() + ", danioEstado()=" + danioEstado() + ", numTurnos()="
                + numTurnos() + "]";
    }

    // Método para reducir en 1 el número de turnos restantes para este estado (no hace nada para Normal)
    @Override
    public void reducirTurnos() {
        // No hace nada para el estado Normal
    }
}
