package Juego;

import ConfiguracionFecade.GameController;

public class Start {

    public static void main(String[] args) {
        // Se crea una instancia del controlador del juego
        GameController gameController = GameController.getInstancia();
        // Se llama al método para iniciar el juego
        gameController.jugar();
    }

}
