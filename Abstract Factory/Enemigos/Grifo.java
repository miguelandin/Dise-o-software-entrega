package Enemigos;

import Estados.EstadoCongelado;
import Interfaces.Boss;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;

public class Grifo implements Boss {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoCongelado();
    private int puntos;

    public Grifo(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Grifo del Norte";
        this.vida = 40;
        this.danio = 40;
        this.magia = 5;
        this.velocidad = 20;
        this.puntos = 45;
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
		final String RESET = "\u001B[0m";
		System.out.println(AZUL);
        System.out.println("                           _");
        System.out.println("                          _)\\.-.");
        System.out.println("         .-.__,___,_.-=-. )\\`  a`\\_");
        System.out.println("     .-.__\\__,__,__.-=-. `/  \\     `\\");
        System.out.println("     {~,-~-,-~.-~,-,;;;;\\ |   '--;`)/");
        System.out.println("      \\-,~_-~_-,~-,(_(_(;\\/   ,;/");
        System.out.println("       \",-.~_,-~,-~,)_)_)'.  ;;(");
        System.out.println("         `~-,_-~,-~(_(_(_(_\\  `;\\");
        System.out.println("   ,          `\"~~--,)_)_)_)\\_   \\");
        System.out.println("   |\\              (_(_/_(_,   \\  ;");
        System.out.println("   \\ '-.       _.--'  /_/_/_)   | |");
        System.out.println("    '--.\\    .'          /_/    | |");
        System.out.println("        ))  /       \\      |   /.'");
        System.out.println("       //  /,        | __.'|  ||");
        System.out.println("      //   ||        /`    (  ||");
        System.out.println("     ||    ||      .'       \\ \\");
        System.out.println("     ||    ||    .'_         \\ \\");
        System.out.println("      \\\\   //   / _ `\\        \\ \\__");
        System.out.println("jgs    \\'-'/(   _  `\\,;        \\ '--:,");
        System.out.println("        `\"`  `\"` `-,,;         `\"`\",,;");
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
        return "Grifo_Tundra [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
