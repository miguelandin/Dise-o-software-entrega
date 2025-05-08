package Factoria;

import Enemigos.Murcielago_Volcan;
import Enemigos.Esqueleto_Volcan;
import Enemigos.Espada_Encantada;
import Estrategias.Normal_Estrategia;
import Estrategias.Aumentado_Estrategia;
import Interfaces.Murcielago;
import Interfaces.Esqueleto;
import Interfaces.ArmaEncantada;
import Interfaces.Enemigo_Estrategia;
import java.util.Random;

// La clase Factoria_Volcan implementa la creación de enemigos específicos para el mundo del volcán
public class Factoria_Volcan extends FactoriaEnemigos{

    // Método para crear un murciélago específico del volcán
    @Override
    public Murcielago crearMurcielago() {
        return new Murcielago_Volcan(estrategia());
    }
    
    // Método para crear un esqueleto específico del volcán
    @Override
    public Esqueleto crearEsqueleto() {
    	return new Esqueleto_Volcan(estrategia());
    }
    
    // Método para crear una arma encantada específica del volcán
    @Override
    public ArmaEncantada crearArma() {
    	return new Espada_Encantada(estrategia());
    }
    
    // Método privado para seleccionar aleatoriamente la estrategia del enemigo del volcán
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
