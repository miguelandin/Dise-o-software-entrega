package Estados;

import java.util.Random;

import Interfaces.EstadoJugador;

// La clase EstadoEnvenenado implementa el estado de jugador "Envenenado"
public class EstadoEnvenenado implements EstadoJugador {
    private int danio_base = 0; // Daño base del estado
    Random random = new Random(); // Objeto Random para generar números aleatorios
    private int num_turnos = random.nextInt(5) + 1; // Número de turnos aleatorio entre 1 y 5

    // Método para obtener el nombre del estado
    @Override
    public String nombreEstado() {
        return "Envenenado";
    }

    // Método para obtener el daño causado por este estado
    @Override
    public int danioEstado() {
        danio_base++; // Incrementa el daño base en cada llamada
        return danio_base; // Devuelve el daño base
    }

    // Método para obtener el número de turnos restantes para este estado
    @Override
    public int numTurnos() {
        return num_turnos; // Devuelve el número de turnos restantes
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "EstadoEnvenenado [nombreEstado()=" + nombreEstado() + ", danioEstado()=" + danioEstado()
                + ", numTurnos()=" + numTurnos() + "]";
    }

    // Método para reducir en 1 el número de turnos restantes para este estado
    @Override
    public void reducirTurnos() {
        num_turnos -= 1;
    }
}
