package Estados;

import java.util.Random;

import Interfaces.EstadoJugador;

// La clase EstadoQuemado implementa el estado de jugador "Quemado"
public class EstadoQuemado implements EstadoJugador {
    Random random = new Random(); // Objeto Random para generar números aleatorios
    private int num_turnos = random.nextInt(5) + 1; // Número de turnos para este estado (entre 1 y 5)

    // Método para obtener el nombre del estado
    @Override
    public String nombreEstado() {
        return "Quemado";
    }

    // Método para obtener el daño causado por este estado (siempre 10 para Quemado)
    @Override
    public int danioEstado() {
        return 10;
    }

    // Método para obtener el número de turnos restantes para este estado
    @Override
    public int numTurnos() {
        return num_turnos;
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "EstadoQuemado [nombreEstado()=" + nombreEstado() + ", danioEstado()=" + danioEstado() + ", numTurnos()="
                + numTurnos() + "]";
    }

    // Método para reducir en 1 el número de turnos restantes para este estado
    @Override
    public void reducirTurnos() {
        num_turnos -= 1;
    }
}
