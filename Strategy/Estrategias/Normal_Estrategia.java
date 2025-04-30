package Estrategias;

import Interfaces.Murcielago_Estrategia;

// La clase Normal_Estrategia implementa la interfaz Murcielago_Estrategia y define una estrategia de ataque normal
public class Normal_Estrategia implements Murcielago_Estrategia {

    @Override
    public double aumentarPosibilidadEfecto() {
        return 0; // Devuelve 0 para indicar que no hay aumento en la posibilidad de efecto especial
    }

    @Override
    public String toString() {
        return "Ataque_Estrategia [calcularOpcion()=" + aumentarPosibilidadEfecto() + "]";
    }
}
