package Enemigos;

import Estados.EstadoCongelado;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Interfaces.Murcielago;
import Interfaces.Murcielago_Estrategia;

// La clase Murcielago_Tundra implementa la interfaz Murcielago y representa un tipo de enemigo
public class Murcielago_Tundra implements Murcielago {
    private Murcielago_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoCongelado();
    private int puntos;

    // Constructor que recibe la estrategia del murciélago
    public Murcielago_Tundra(Murcielago_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Murcielago de la Tundra";
        this.vida = 20;
        this.danio = 10;
        this.magia = 0;
        this.velocidad = 3;
        this.puntos = 8;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getVida() {
        // Multiplica la vida del murciélago por la dificultad del mundo TUNDRA
        return vida * Mundos.TUNDRA.getDificultad();
    }

    @Override
    public int getDanio() {
        // Multiplica el daño del murciélago por la dificultad del mundo TUNDRA
        return danio * Mundos.TUNDRA.getDificultad();
    }

    @Override
    public int getMagia() {
        // Multiplica la magia del murciélago por la dificultad del mundo TUNDRA
        return magia * Mundos.TUNDRA.getDificultad();
    }

    @Override
    public int getVelocidad() {
        // Multiplica la velocidad del murciélago por la dificultad del mundo TUNDRA
        return velocidad * Mundos.TUNDRA.getDificultad();
    }

    @Override
    public EstadoJugador estadoAplicable() {
        // Devuelve el estado congelado aplicable al murciélago de la tundra
        return estadoJugador;
    }
    
    @Override
    public Murcielago_Estrategia estrategia() {
        return estrategia;
    }

    @Override
    public String toString() {
        return "Murcielago_Bosque [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
    }

    @Override
    public void recibirAtaque(int danio) {
        // Reduce la vida del murciélago al recibir un ataque
        this.vida -= danio;
    }

    @Override
    public int getPuntos() {
        return puntos;
    }
}
