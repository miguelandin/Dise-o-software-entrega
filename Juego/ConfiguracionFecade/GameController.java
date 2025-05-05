package ConfiguracionFecade;

import java.util.InputMismatchException;
import java.util.Scanner;
import Factoria.FactoriaEnemigos;
import Factoria.Factoria_Bosque;
import Factoria.Factoria_Tundra;
import Factoria.Factoria_Volcan;
import Interfaces.Enemigo;
import Interfaces.Mundos;
import Interfaces.Murcielago;
import Jugador.Jugador;

public class GameController {
    
    private static GameController instancia = new GameController();
    private static CalculadoraController calculadora = CalculadoraController.getInstancia();
    
    private FactoriaEnemigos factoriaEnemigos = new Factoria_Bosque();
    // Mundo inicial: Bosque
    private Mundos mundos = Mundos.BOSQUE;
    
    private GameController(){}
    
    public static GameController getInstancia() {
        return instancia;
    }
    
    public void jugar() {        
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("--- BIENVENIDO A RPGLAND ---");
        
        // Se crea el jugador
        Jugador jugador = crearJugador(teclado);
        Murcielago murcielago;
        
        murcielago = factoriaEnemigos.crearMurcielago();
        
        // Bucle principal del juego, mientras el jugador tenga vida
        while(jugador.getVida() > 0) {
            if(jugador.getVida() > 0) System.out.println("MUNDO: " + mundos.getNombre());
            
            // Se juega en el mundo actual
            if(jugador.getVida() > 0) jugarMundo(jugador, murcielago);
            
            // Se cambia al siguiente mundo
            if(jugador.getVida() > 0) cambiarMundo();
            
            if(jugador.getVida() > 0) System.out.println("MUNDO: " + mundos.getNombre());
            
            if(jugador.getVida() > 0) murcielago = factoriaEnemigos.crearMurcielago();
            
            // Se juega en el nuevo mundo con el nuevo enemigo
            if(jugador.getVida() > 0) jugarMundo(jugador, murcielago);
            
            // Se cambia al siguiente mundo nuevamente
            if(jugador.getVida() > 0) cambiarMundo();
            
            // Se repite el bucle, mejorando enemigos
            if(jugador.getVida() > 0) System.out.println("Se repite el bucle, mejorando enemigos");
        }
        
        System.out.println("El jugador ha perdido.");
        
        teclado.close();
    }
    
    public void cambiarMundo() {
        if(this.mundos == Mundos.BOSQUE) {
            mundos = Mundos.TUNDRA;
            factoriaEnemigos = new Factoria_Tundra();
        }
        else if(this.mundos == Mundos.TUNDRA) {
            mundos = Mundos.VOLCAN;
            factoriaEnemigos = new Factoria_Volcan();
        }
        else if(this.mundos == Mundos.VOLCAN) {
            mundos = Mundos.BOSQUE;
            factoriaEnemigos = new Factoria_Bosque();
        }
    }
    
    public static Jugador crearJugador(Scanner teclado) {
        
        Jugador jugador;

        String nombre;
        int eleccion, eleccion2, danio = 1, magia = 1, velocidad = 1, armadura = 1, puntos = 25, puntos_eleccion = 0;
        
        System.out.print("\nTu nombre: ");
        nombre = teclado.next();
        
        do {
            System.out.print("\nSelecciona una opcion para tu personaje:"
                    + "\n1. Crear tu personaje"
                    + "\n2. Elegir una opcion predefinida"
                    + "\nSeleccion: ");
            
            eleccion = teclado.nextInt();
            
            switch(eleccion) {
                case 1:
                    System.out.println("\nDebes repartir los " + puntos + " puntos en las estadÃ­sticas:");
                    do {
                    	System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                        System.out.print("Daño: ");
                        puntos_eleccion = teclado.nextInt();
                    }while((puntos - puntos_eleccion) < 0);
                    
                    danio = puntos_eleccion;
                    puntos -= puntos_eleccion;
                    
                    if(puntos > 0) {
                    	System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                        System.out.println("Puntos restantes: " + puntos);
                        
                        do {
                            System.out.print("Magia: ");
                            puntos_eleccion = teclado.nextInt();
                        }while((puntos - puntos_eleccion) < 0);
                        
                        magia = puntos_eleccion;
                        puntos -= puntos_eleccion;
                        
                        if(puntos > 0) {
                        	System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                            System.out.println("Puntos restantes: " + puntos);
                            
                            do {
                                System.out.print("Armadura: ");
                                puntos_eleccion = teclado.nextInt();
                            }while((puntos - puntos_eleccion) < 0);
                            
                            armadura = puntos_eleccion;
                            puntos -= puntos_eleccion;
                            
                            if(puntos > 0) {
                                System.out.println("\nPuntos restantes para velocidad: " + puntos);
                                velocidad = puntos;
                            	System.out.println("Distribucion de puntos: \n » Fuerza: " + danio + "\n » Magia: " + magia + "\n » Armadura: " + armadura + "\n » Velocidad: " + velocidad + "\n");

                            }
                        }
                    }
                    
                    break;
                    
                case 2:
                    
                    do {
                        System.out.println("\nPersonajes disponibles:"
                                + "\nSeleccion: ");
                        
                        eleccion2 = teclado.nextInt();
                    }while(eleccion2 < 1 || eleccion2 > 3);
                    
                    switch(eleccion2) {
                        case 1:
                             danio = 10;
                             magia = 1;
                             armadura = 8;
                             velocidad = 6;
                            break;
                        
                        case 2:
                            danio = 5;
                            magia = 1;
                            armadura = 15;
                            velocidad = 4;
                            break;
                            
                        case 3:
                             danio = 2;
                             magia = 15;
                             armadura = 2;
                             velocidad = 6;
                            break;
                            
                        default:
                            System.out.println("ERROR. Debes introducir una opcion valida.");
                            break;
                    }
                    
                    break;
                
                default:
                        System.out.println("ERROR. Debes introducir una opcion valida.");
                    break;
            }
        }while(eleccion < 1 || eleccion > 2);
        
        // Se crea la instancia del jugador con los atributos proporcionados
        jugador = Jugador.getInstancia(nombre, 100, danio, magia, armadura, velocidad);
        
        return jugador;
    }
    
    private String mostrarMurcielago(Murcielago murcielago) {
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
        return "HP: " + murcielago.getVida();
    }
    
    private String mostrarJugador(Jugador jugador) {
        return "HP: " + jugador.getVida() + ", ATK: " + jugador.getFuerza() + ", DEF: " + jugador.getArmadura() + ", MAG: " + jugador.getMagia() + ", VEL: " + jugador.getVelocidad();
    }
    
    private void jugarMundo(Jugador jugador, Murcielago murcielago) {        
        Scanner teclado = new Scanner(System.in);

        int eleccion = 0;
        
        while(murcielago.getVida() > 0 && jugador.getVida() > 0) {
            
            System.out.println(jugador.getNombre() + " -> " + mostrarJugador(jugador));
            System.out.println(murcielago.getNombre() + " ->" + mostrarMurcielago(murcielago));
            
            System.out.println("Que quieres hacer:"
                    + "\n1. Atacar."
                    + "\n2. Magia."
                    + "\nEleccion: ");
            
            eleccion = teclado.nextInt();
            
            switch(eleccion) {
                case 1:
                    if(jugador.getVelocidad() > murcielago.getVelocidad()) {
                        calculadora.atacar_jugador(jugador, murcielago);
                        calculadora.atacar_enemigo(murcielago, jugador);
                    }else {
                        calculadora.atacar_enemigo(murcielago, jugador);
                        calculadora.atacar_jugador(jugador, murcielago);
                    }
                    break;
                    
                case 2:
                    System.out.println("Que quieres hacer:"
                            + "\n1. Curar."
                            + "\n2. Proteger."
                            + "\n3. Examinar enemigo."
                            + "\nEleccion: ");
                    
                    eleccion = teclado.nextInt();
                    
                    switch(eleccion) {
                        case 1:
                            if(jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.curar(jugador);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            }else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.curar(jugador);
                            }
                            break;
                            
                        case 2:
                            if(jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.Proteger(jugador);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            }else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.Proteger(jugador);
                            }
                            break;
                            
                        case 3:
                            if(jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.examinar_enemigo(jugador, murcielago);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            }else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.examinar_enemigo(jugador, murcielago);
                            }
                            break;
                    }
                    
                    break;
            }
            
            if(!jugador.getEstado().nombreEstado().equals("Normal")) {
                calculadora.recibir_danio_estado(jugador);
            }
        }
    }
    
}
