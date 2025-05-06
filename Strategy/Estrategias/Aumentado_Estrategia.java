package Estrategias;

import Interfaces.Enemigo_Estrategia;

// La clase Aumentado_Estrategia implementa la interfaz Enemigo_Estrategia y define una estrategia de ataque aumentado
public class Aumentado_Estrategia implements Enemigo_Estrategia {

    @Override
    public double aumentarPosibilidadEfecto() {
        return 3; // Devuelve 3 para indicar un aumento significativo en la posibilidad de efecto especial
    }

    @Override
    public String toString() {
        return "Ataque_Estrategia [calcularOpcion()=" + aumentarPosibilidadEfecto() + "]";
    }
}
