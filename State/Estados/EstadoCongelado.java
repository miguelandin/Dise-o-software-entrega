package Estados;

import java.util.Random;

import Interfaces.EstadoJugador;

// La clase EstadoCongelado implementa el estado de jugador "Congelado"
public class EstadoCongelado implements EstadoJugador {
    // Se utiliza un objeto Random para generar un número aleatorio de turnos
    Random random = new Random();

    // Se inicializa el número de turnos aleatorio entre 1 y 5
    private int num_turnos = random.nextInt(5) + 1;

    // Método para obtener el nombre del estado
    @Override
    public String nombreEstado() {
        return "Congelado";
    }

    // Método para obtener el daño causado por este estado
    @Override
    public int danioEstado() {
        return 0; // El estado Congelado no causa daño directo al jugador
    }

    // Método para obtener el número de turnos restantes para este estado
    @Override
    public int numTurnos() {
        return num_turnos;
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "EstadoCongelado [nombreEstado()=" + nombreEstado() + ", danioEstado()=" + danioEstado()
                + ", numTurnos()=" + numTurnos() + "]";
    }

    // Método para reducir en 1 el número de turnos restantes para este estado
    @Override
    public void reducirTurnos() {
        num_turnos -= 1;
    }
}
