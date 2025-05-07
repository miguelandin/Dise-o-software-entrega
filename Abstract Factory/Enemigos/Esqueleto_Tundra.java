package Enemigos;

import Interfaces.Enemigo_Estrategia;
import Interfaces.Esqueleto;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;
import Estados.EstadoCongelado;


public class Esqueleto_Tundra implements Esqueleto {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoCongelado();
    private int puntos;

    public Esqueleto_Tundra(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Esqueleto de Tundra";
        this.vida = 50;
        this.danio = 10;
        this.magia = 0;
        this.velocidad = 1;
        this.puntos = 8;
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
		System.out.println("               .7");
        System.out.println("            .'/");
        System.out.println("           / /");
        System.out.println("          / /");
        System.out.println("         / /");
        System.out.println("        / /");
        System.out.println("       / /");
        System.out.println("      / /");
        System.out.println("     / /         ");
        System.out.println("    / /          ");
        System.out.println("  __|/");
        System.out.println(",-\\__\\");
        System.out.println("|f-\"Y\\|");
        System.out.println("\\()7L/");
        System.out.println(" cgD                            __ _");
        System.out.println(" |\\(                          .'  Y '>,");
        System.out.println("  \\ \\                        / _   _   \\");
        System.out.println("   \\\\                       )(_) (_)(|}");
        System.out.println("    \\\\                      {  4A   } /");
        System.out.println("     \\\\                      \\uLuJJ/\\l");
        System.out.println("      \\\\                     |3    p)/");
        System.out.println("       \\\\___ __________      /nnm_n//");
        System.out.println("       c7___-__,__-)\b__)(\".  \\_>-<_/D");
        System.out.println("                  //V     \\_\"-._.__G G_c__.-__<\"/ ( \\");
        System.out.println("                         <\"-._>__-,G_.___)\\   \\7\\");
        System.out.println("                        (\"-.__.| \\\"<.__.-\" )   \\ \\");
        System.out.println("                        |\"-.__\"\\  |\"-.__.-\".\\   \\ \\");
        System.out.println("                        (\"-.__\"\". \\\"-.__.-\".|    \\_\\");
        System.out.println("                        \\\"-.__\"\"|!|\"-.__.-\".)     \\ \\");
        System.out.println("                         \"-.__\"\"\\_|\"-.__.-\"./      \\ l");
        System.out.println("                          \".__\"\">G>-.__.-\">       .--,_");
        System.out.println("                              \"\"  G");
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
        return "Esqueleto_Tundra [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
