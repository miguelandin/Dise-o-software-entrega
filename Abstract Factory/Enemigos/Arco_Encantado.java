package Enemigos;

import Estados.EstadoEnvenenado;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Interfaces.ArmaEncantada;

public class Arco_Encantado implements ArmaEncantada {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoEnvenenado();
    private int puntos;

    public Arco_Encantado(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Arco Encantado con veneno";
        this.vida = 7;
        this.danio = 15;
        this.magia = 10;
        this.velocidad = 10;
        this.puntos = 10;
    }
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getVida() {
		return vida * Mundos.BOSQUE.getDificultad();
	}

	@Override
	public int getDanio() {
		return danio * Mundos.BOSQUE.getDificultad();
	}

	@Override
	public int getMagia() {
		return magia * Mundos.BOSQUE.getDificultad();
	}

	@Override
	public int getVelocidad() {
		return velocidad * Mundos.BOSQUE.getDificultad();
	}

	@Override
	public void recibirAtaque(int danio) {
		this.vida -= danio;
	}

	@Override
	public int getPuntos() {
		return puntos;
	}

	@Override
	public void printAscii() {
		final String VERDE = "\u001B[32m";
		final String MARRON = "\u001B[33m";
		final String RESET = "\u001B[0m";
		System.out.println(MARRON);
        System.out.println("           4$-.");
        System.out.println("           4   \".");
        System.out.println("           4    ^.");
        System.out.println("           4     $");
        System.out.println("           4     'b");
        System.out.println("           4      \"b.");
        System.out.println("           4        $");
        System.out.println("           4        $r");
        System.out.println("           4        $F");
        System.out.println(VERDE);
        System.out.println("-$b========4========$b====*P=-");
        System.out.println(MARRON);
        System.out.println("           4       *$F");
        System.out.println("           4        $\"");
        System.out.println("           4       .$F");
        System.out.println("           4       dP");
        System.out.println("           4      F");
        System.out.println("           4     @");
        System.out.println("           4    .");
        System.out.println("           J.");
        System.out.println("          '$'");
        System.out.println(RESET);
	}

	@Override
	public EstadoJugador estadoAplicable() {
		return estadoJugador;
	}

	@Override
	public Enemigo_Estrategia estrategia() {
		return estrategia;
	}
	
	@Override
	public String toString() {
        return "Arco_Encantado [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
