package Factoria;

import Interfaces.Murcielago;
import Interfaces.Esqueleto;
import Interfaces.ArmaEncantada;

// La clase abstracta FactoriaEnemigos proporciona un método abstracto para crear murciélagos
public abstract class FactoriaEnemigos {
    // Método abstracto para crear un murciélago
    public abstract Murcielago crearMurcielago();
    
    // Método abstracto para crear un esqueleto
    public abstract Esqueleto crearEsqueleto();
    
    // Método abstracto para crear una arma encantada
    public abstract ArmaEncantada crearArma();
}
