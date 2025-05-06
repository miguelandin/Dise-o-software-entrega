package Factoria;

import java.util.Random;
import Enemigos.Murcielago_Tundra;
import Enemigos.Esqueleto_Tundra;
import Estrategias.Normal_Estrategia;
import Estrategias.Aumentado_Estrategia;
import Interfaces.Murcielago;
import Interfaces.Esqueleto;
import Interfaces.Enemigo_Estrategia;

// La clase Factoria_Tundra implementa la creación de enemigos específicos para el mundo de la tundra
public class Factoria_Tundra extends FactoriaEnemigos {

    // Método para crear un murciélago específico de la tundra
    @Override
    public Murcielago crearMurcielago() {
        return new Murcielago_Tundra(estrategia());
    }
    
    // Método para crear un esqueleto específico de la tundra
    @Override
    public Esqueleto crearEsqueleto() {
    	return new Esqueleto_Tundra(estrategia());
    }
    
    // Método privado para seleccionar aleatoriamente la estrategia del enemigo de la tundra
    private Enemigo_Estrategia estrategia() {
        Random random = new Random();
        int randomNumber = random.nextInt(3) + 1; // Genera un número aleatorio entre 1 y 3
        Enemigo_Estrategia estrategia = null;
        
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
