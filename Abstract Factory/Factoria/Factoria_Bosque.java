package Factoria;

import java.util.Random;

import Enemigos.Murcielago_Bosque;
import Estrategias.Normal_Estrategia;
import Estrategias.Aumentado_Estrategia;
import Interfaces.Murcielago;
import Interfaces.Murcielago_Estrategia;

// La clase Factoria_Bosque implementa la creación de enemigos específicos para el mundo del bosque
public class Factoria_Bosque extends FactoriaEnemigos {

    // Método para crear un murciélago específico del bosque
    @Override
    public Murcielago crearMurcielago() {
        return new Murcielago_Bosque(estrategia());
    }
    
    // Método privado para seleccionar aleatoriamente la estrategia del murciélago del bosque
    private Murcielago_Estrategia estrategia() {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1; // Genera un número aleatorio entre 1 y 2
        Murcielago_Estrategia estrategia = null;
        
        switch(randomNumber) {
            case 1:
                estrategia = new Normal_Estrategia(); // Estrategia normal
                break;
            case 2:
                estrategia = new Aumentado_Estrategia(); // Estrategia aumentada
                break;
        }
        
        return estrategia;
    }

}
