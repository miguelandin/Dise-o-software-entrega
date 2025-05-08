package Enemigos;

import Estados.EstadoCongelado;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Interfaces.ArmaEncantada;

public class Acha_Encantada implements ArmaEncantada {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoCongelado();
    private int puntos;

    public Acha_Encantada(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Acha Encantada de hielo";
        this.vida = 20;
        this.danio = 35;
        this.magia = 10;
        this.velocidad = 1;
        this.puntos = 10;
    }
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getVida() {
		return vida * Mundos.TUNDRA.getDificultad();
	}

	@Override
	public int getDanio() {
		return danio * Mundos.TUNDRA.getDificultad();
	}

	@Override
	public int getMagia() {
		return magia * Mundos.TUNDRA.getDificultad();
	}

	@Override
	public int getVelocidad() {
		return velocidad * Mundos.TUNDRA.getDificultad();
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
		final String AZUL = "\u001B[34m";
		final String MARRON = "\u001B[33m";
		final String RESET = "\u001B[0m";
		System.out.println(MARRON);
        System.out.println(" _________________.---.______");
        System.out.println("(_(______________(_o o_(____()");
        System.out.print(AZUL);
        System.out.println("             .___.'. .'.___.");
        System.out.println("             \\ o    Y    o /");
        System.out.println("              \\ \\__   __/ /");
        System.out.println("               '.__'-'__.'");
        System.out.println("                   '''");
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
        return "Acha_Encantada [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
