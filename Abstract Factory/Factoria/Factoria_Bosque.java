package Factoria;

import java.util.Random;
import Enemigos.Murcielago_Bosque;
import Enemigos.Esqueleto_Bosque;
import Enemigos.Arco_Encantado;
import Enemigos.Ciclope;
import Estrategias.Normal_Estrategia;
import Estrategias.Aumentado_Estrategia;
import Interfaces.Murcielago;
import Interfaces.Esqueleto;
import Interfaces.ArmaEncantada;
import Interfaces.Boss;
import Interfaces.Enemigo_Estrategia;

// La clase Factoria_Bosque implementa la creación de enemigos específicos para el mundo del bosque
public class Factoria_Bosque extends FactoriaEnemigos {

    // Método para crear un murciélago específico del bosque
    @Override
    public Murcielago crearMurcielago() {
        return new Murcielago_Bosque(estrategia());
    }
    
    // Método para crear un esqueleto específico del bosque
    @Override
    public Esqueleto crearEsqueleto() {
    	return new Esqueleto_Bosque(estrategia());
    }
   
    // Método para crear una arma encantada específica del bosque 
    @Override
    public ArmaEncantada crearArma() {
    	return new Arco_Encantado(estrategia());
    }
    
    @Override
    public Boss crearBoss() {
    	return new Ciclope(estrategia());
    }
    
    // Método privado para seleccionar aleatoriamente la estrategia del enemigo del bosque
    private Enemigo_Estrategia estrategia() {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1; // Genera un número aleatorio entre 1 y 2
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
