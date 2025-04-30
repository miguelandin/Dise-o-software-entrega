package Factoria;

import Enemigos.Murcielago_Volcan;
import Estrategias.Normal_Estrategia;
import Estrategias.Aumentado_Estrategia;
import Interfaces.Murcielago;
import Interfaces.Murcielago_Estrategia;
import java.util.Random;

// La clase Factoria_Volcan implementa la creación de enemigos específicos para el mundo del volcán
public class Factoria_Volcan extends FactoriaEnemigos{

    // Método para crear un murciélago específico del volcán
    @Override
    public Murcielago crearMurcielago() {
        return new Murcielago_Volcan(estrategia());
    }
    
    // Método privado para seleccionar aleatoriamente la estrategia del murciélago del volcán
    private Murcielago_Estrategia estrategia() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1; // Genera un número aleatorio entre 1 y 3
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
