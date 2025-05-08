package Enemigos;

import Estados.EstadoQuemado;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Interfaces.ArmaEncantada;

public class Espada_Encantada implements ArmaEncantada {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoQuemado();
    private int puntos;

    public Espada_Encantada(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Espada Encantada de fuego";
        this.vida = 15;
        this.danio = 25;
        this.magia = 10;
        this.velocidad = 5;
        this.puntos = 15;
    }
	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public int getVida() {
		return vida * Mundos.VOLCAN.getDificultad();
	}

	@Override
	public int getDanio() {
		return danio * Mundos.VOLCAN.getDificultad();
	}

	@Override
	public int getMagia() {
		return magia * Mundos.VOLCAN.getDificultad();
	}

	@Override
	public int getVelocidad() {
		return velocidad * Mundos.VOLCAN.getDificultad();
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
		final String ROJO = "\u001B[31m";
		final String GRIS = "\u001B[37m";
		final String RESET = "\u001B[0m";
        System.out.println(GRIS);
        System.out.println("              />");
        System.out.print(" ()          //");
        System.out.println(ROJO + "---------------------------------------------------------(" + GRIS);
        System.out.print("(*)OXOXOXOXO(*>");
        System.out.println(ROJO + "                                                         \\" + GRIS);
        System.out.print(" ()          \\\\");
        System.out.println(ROJO + "-----------------------------------------------------------)" + GRIS);
        System.out.print("              \\>");
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
        return "Espada_Encantada [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}


}
