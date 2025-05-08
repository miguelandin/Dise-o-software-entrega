package Enemigos;

import Estados.EstadoQuemado;
import Interfaces.Boss;
import Interfaces.Enemigo_Estrategia;
import Interfaces.EstadoJugador;
import Interfaces.Mundos;

public class Dragon implements Boss {
	private Enemigo_Estrategia estrategia;
    private String nombre;
    private int vida;
    private int danio;
    private int magia;
    private int velocidad;
    private EstadoJugador estadoJugador = new EstadoQuemado();
    private int puntos;

    public Dragon(Enemigo_Estrategia estrategia) {
        this.estrategia = estrategia;
        this.nombre = "Dragon de Lava";
        this.vida = 100;
        this.danio = 50;
        this.magia = 25;
        this.velocidad = 5;
        this.puntos = 1000;
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
		printAsciiAttack();
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
		final String RESET = "\u001B[0m";
		System.out.println(ROJO);
        System.out.println("                         ^                       ^                       ");
        System.out.println("                         |\\   \\        /        /|                      ");
        System.out.println("                        /  \\  |\\__  __/|       /  \\                     ");
        System.out.println("                       / /\\ \\ \\ _ \\/ _ /      /    \\                    ");
        System.out.println("                      / / /\\ \\ {*}\\/{*}      /  / \\ \\                   ");
        System.out.println("                      | | | \\ \\( (00) )     /  // |\\ \\                  ");
        System.out.println("                      | | | | \\(V\"\"V)\\    /  / | || \\|                  ");
        System.out.println("                      | | | |  \\|^--^| \\  /  / || || ||                 ");
        System.out.println("                     / / /  | |( WWWW__ \\/  /| || || ||                  ");
        System.out.println("                    | | | | | |  \\______\\  / / || || ||                  ");
        System.out.println("                    | | | / | | )|______\\ ) | / | || ||                  ");
        System.out.println("                    / / /  / /  /______/   /| \\ \\ || ||                 ");
        System.out.println("                   / / /  / /  /\\_____/  |/ /__\\ \\ \\ \\                 ");
        System.out.println("                   | | | / /  /\\______/    \\   \\__| \\ \\ \\               ");
        System.out.println("                   | | | | | |\\______ __    \\_    \\__|_| \\              ");
        System.out.println("                   | | ,___ /\\______ _  _     \\_       \\  |             ");
        System.out.println("                   | |/    /\\_____  /    \\      \\__     \\ |    /\\       ");
        System.out.println("                   |/ |   |\\______ |      |        \\___  \\ |__/  \\      ");
        System.out.println("                   v  |   |\\______ |      |            \\___/     |      ");
        System.out.println("                      |   |\\______ |      |                    __/       ");
        System.out.println("                       \\   \\________\\_    _\\               ____/         ");
        System.out.println("                     __/   /\\_____ __/   /   )\\_,      _____/            ");
        System.out.println("                    /  ___/  \\uuuu/  ___/___)    \\______/");
        System.out.println("                    VVV  V        VVV  V                          ");
        System.out.println(RESET);
	}
	
	private void printAsciiAttack() {
		final String ROJO = "\u001B[31m";
		final String RESET = "\u001B[0m";
		System.out.println(ROJO);
        System.out.println("                                             ,--,  ,.-.                ");
        System.out.println("               ,                   \\       '-,-`,'-.' | ._             ");
        System.out.println("              /|           \\    ,   |\\         }  )/  / `-,',         ");
        System.out.println("              [ ,          |\\  /|   | |        /  \\|  |/`  ,`         ");
        System.out.println("              | |       ,.`  `,` `, | |  _,...(   (      .',          ");
        System.out.println("              \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\        ");
        System.out.println("               \\  \\_\\,``,   ` , ,  /  |         )         _,/         ");
        System.out.println("                \\  '  `  ,_ _`_,-,<._.<        /         /            ");
        System.out.println("                 ', `>.,`  `  `   ,., |_      |         /              ");
        System.out.println("                   \\/`  `,   `   ,`  | /__,.-`    _,   `\\             ");
        System.out.println("               -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\            ");
        System.out.println("                \\_,,.) /\\    ` /  / ) (-,, ``    ,        |           ");
        System.out.println("               ,` )  | \\_\\       '-`  |  `(               \\           ");
        System.out.println("              /  /```(   , --, ,' \\   |`<`    ,            |           ");
        System.out.println("             /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)          ");
        System.out.println("       ,-, ,`   `   (_,/\\ \\    |   /) / __/  /   `----`                 ");
        System.out.println("      (-, \\           ) \\ ('_.-._)/ /,`    /                       ");
        System.out.println("      | /  `          `/ \\\\ V   V, /`     /                        ");
        System.out.println("   ,--\\(        ,     <_/`\\\\     ||      /                         ");
        System.out.println("  (   ,``-     \\/|         \\-A.A-`|     /                          ");
        System.out.println(" ,>,_ )_,..(    )\\          -,,_-`  _--`                           ");
        System.out.println("(_ \\|`   _,/_  /  \\_            ,--`                               ");
        System.out.println(" \\( `   <.,../`     `-.._   _,-`                                   ");
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
        return "Dragon_Volcan [estrategia=" + estrategia + ", nombre=" + nombre + ", vida=" + vida + ", danio="
                + danio + ", magia=" + magia + ", velocidad=" + velocidad + ", estadoJugador=" + estadoJugador
                + ", puntos=" + puntos + "]";
	}

}
