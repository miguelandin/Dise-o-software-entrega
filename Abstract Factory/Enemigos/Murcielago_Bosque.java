package Enemigos;

import Estados.EstadoEnvenenado;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Interfaces.Murcielago;
import Interfaces.Enemigo_Estrategia;

// La clase Murcielago_Bosque implementa la interfaz Murcielago y representa un tipo de enemigo
public class Murcielago_Bosque implements Murcielago {
    private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoEnvenenado();
    private int puntos;
    
    // Constructor que recibe la estrategia del murciélago
    public Murcielago_Bosque(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Murcielago del Bosque";
        this.vida = 20;
        this.danio = 10;
        this.magia = 0;
        this.velocidad = 3;
        this.puntos = 5;
    }
    
    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getVida() {
        // Multiplica la vida del murciélago por la dificultad del mundo BOSQUE
        return vida * Mundos.BOSQUE.getDificultad();
    }

    @Override
    public int getDanio() {
        // Multiplica el daño del murciélago por la dificultad del mundo BOSQUE
        return danio * Mundos.BOSQUE.getDificultad();
    }

    @Override
    public int getMagia() {
        // Multiplica la magia del murciélago por la dificultad del mundo BOSQUE
        return magia * Mundos.BOSQUE.getDificultad();
    }

    @Override
    public int getVelocidad() {
        // Multiplica la velocidad del murciélago por la dificultad del mundo BOSQUE
        return velocidad * Mundos.BOSQUE.getDificultad();
    }

    @Override
    public EstadoJugador estadoAplicable() {
        // Devuelve el estado envenenado aplicable al murciélago del bosque
        return estadoJugador;
    }
    
    @Override
    public Enemigo_Estrategia estrategia() {
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
    
    @Override
    public void printAscii() {
    	final String VERDE = "\u001B[32m";
    	final String RESET = "\u001B[0m";
    	System.out.println(VERDE);
        System.out.println("      ....._      ");
        System.out.println("     `.   ``-.                               .-----.._");
        System.out.println("       `,     `-.                          .:      /`");
        System.out.println("         :       `\"..                 ..-``       :");
        System.out.println("         /   ...--:::`n            n.`::...       :");
        System.out.println("         `:``      .` ::          /  `.     ``---..:.");
        System.out.println("           `\\    .`  ._:  .-:   ::    `.     .-``");
        System.out.println("             :  :    :_\\_/: :  .::      `.   /");
        System.out.println("             : /      \\-../:/_.`-`        \\ :");
        System.out.println("             :: _.._  Ø` Ø` /`              \\|");
        System.out.println("             :-`    ``(_. ..-----hh``````/-._:");
        System.out.println("                         `:      ``     /     `");
        System.out.println("                         E:            /");
        System.out.println("                          :          _/");
        System.out.println("                          :    _..-``");
        System.out.println("                          l--``");
        System.out.println(RESET);
    }
}
