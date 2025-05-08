package Enemigos;

import Estados.EstadoEnvenenado;
import Interfaces.Boss;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;

public class Ciclope implements Boss {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoEnvenenado();
    private int puntos;

    public Ciclope(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Ciclope del Bosque";
        this.vida = 70;
        this.danio = 30;
        this.magia = 0;
        this.velocidad = 1;
        this.puntos = 25;
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
		final String RESET = "\u001B[0m";
		System.out.println(VERDE);
        System.out.println("           _......._");
        System.out.println("       .-'.'.'.'.'.'.`-.");
        System.out.println("     .'.'.'.'.'.'.'.'.'.`.");
        System.out.println("    /.'.'               '.\\");
        System.out.println("    |.'    _.--...--._     |");
        System.out.println("    \\    `._.-.....-._.'   /");
        System.out.println("    |     _..- .-. -.._   |");
        System.out.println(" .-.'    `.   ((@))  .'   '.-.");
        System.out.println("( ^ \\      `--.   .-'     / ^ )");
        System.out.println(" \\  /         .   .       \\  /");
        System.out.println(" /          .'     '.  .-    \\");
        System.out.println("( _.\\    \\ (_`-._.-'_)    /._\\)");
        System.out.println(" `-' \\   ' .--.          / `-'");
        System.out.println("     |  / /|_| `-._.'\\   |");
        System.out.println("     |   |       |_| |   /-.._");
        System.out.println(" _..-\\   `.--.______.'  |");
        System.out.println("      \\       .....     |");
        System.out.println("       `.  .'      `.  /");
        System.out.println("         \\           .'");
        System.out.println("          `-..___..-`");
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
        return "Ciclope_Bosque [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
