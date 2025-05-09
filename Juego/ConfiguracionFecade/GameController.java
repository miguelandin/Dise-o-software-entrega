package ConfiguracionFecade;

import java.util.Random;
import java.util.Scanner;
import Factoria.FactoriaEnemigos;
import Factoria.Factoria_Bosque;
import Factoria.Factoria_Tundra;
import Factoria.Factoria_Volcan;
import Interfaces.Enemigo;
import Interfaces.Mundos;
import Jugador.Jugador;
import refactorizacion.ExtraccionDeMetodo;

public class GameController {

    // Instancia Ãºnica del controlador del juego
    private static GameController instancia = new GameController();
    // Instancia del controlador de la calculadora para realizar cÃ¡lculos
    // relacionados con el juego
    private static CalculadoraController calculadora = CalculadoraController.getInstancia();

    // FactorÃ­a de enemigos inicial: Bosque
    private FactoriaEnemigos factoriaEnemigos = new Factoria_Bosque();
    // Mundo inicial: Bosque
    private Mundos mundos = Mundos.BOSQUE;

    private GameController() {
    }

    // MÃ©todo estÃ¡tico para obtener la instancia Ãºnica del controlador del juego
    public static GameController getInstancia() {
        return instancia;
    }

    // MÃ©todo principal para comenzar el juego
    public void jugar() {
        Scanner teclado = new Scanner(System.in);

        System.out.println(" ____            _        ____  _                       ");
        System.out.println("|  _ \\ _ __ __ _| | _____/ ___|| | __ _ _   _  ___ _ __ ");
        System.out.println("| | | | '__/ _` | |/ / _ \\___ \\| |/ _` | | | |/ _ \\ '__|");
        System.out.println("| |_| | | | (_| |   <  __/___) | | (_| | |_| |  __/ |   ");
        System.out.println("|____/|_|  \\__,_|_|\\_\\___|____/|_|\\__,_|\\__, |\\___|_|   ");
        System.out.println("                                        |___/            ");
        System.out.println("Antes de comenzar la aventura, pasaremos a la creacion de tu personaje: ");

        // Se crea el jugador
        Jugador jugador = crearJugador(teclado);
        Enemigo enemigo = factoriaEnemigos.crearMurcielago();


        // Bucle principal del juego, mientras el jugador tenga vida
        while (jugador.getVida() > 0) {
            // Se verifica si el jugador estÃ¡ vivo antes de cada acciÃ³n
            if (jugador.getVida() > 0)
                System.out.println("MUNDO: " + mundos.getNombre());

            // Se juega en el mundo actual
            if (jugador.getVida() > 0)
                jugarMundo(jugador, enemigo);

            // Se cambia al siguiente mundo
            if (jugador.getVida() > 0)
                cambiarMundo();

            // Se verifica si el jugador estÃ¡ vivo despuÃ©s de cambiar de mundo
            if (jugador.getVida() > 0)
                System.out.println("MUNDO: " + mundos.getNombre());

            // Se crea un nuevo enemigo para el prÃ³ximo encuentro
            if (jugador.getVida() > 0) {
                // Se crea enemigo aleatorio                
                Random random = new Random();
                int r = random.nextInt(10); // genera un número del 0 al 9
                if(r >= 0 && r <= 2) // 30% de murcielago
                	enemigo = factoriaEnemigos.crearMurcielago();
                else if(r >= 3 && r <= 5) // 30% de esqueleto
                	enemigo = factoriaEnemigos.crearEsqueleto();
                else if(r >= 6 && r <= 8) // 30% de arma encantada
                	enemigo = factoriaEnemigos.crearArma();
                else if(r == 9) // 10% de Jefe
                	enemigo = factoriaEnemigos.crearBoss();
            }
            // Se juega en el nuevo mundo con el nuevo enemigo
            if (jugador.getVida() > 0)
                jugarMundo(jugador, enemigo);

            // Se cambia al siguiente mundo nuevamente
            if (jugador.getVida() > 0)
                cambiarMundo();

            // Se repite el bucle, mejorando enemigos
            if (jugador.getVida() > 0)
                System.out.println("Se repite el bucle, mejorando enemigos");
        }
        
        // fin del juego
        System.out.println(jugador.getNombre() + " ha sido brutalmente asesinado por " + enemigo.getNombre() + "\n ¿Volver a emepezar? (s/n)");
        String respuesta = teclado.next();
        if(respuesta.equalsIgnoreCase("s")) {
        	jugador.curar(100); // la única solución que he encontrado
        	limpiarConsola();
        	jugar(); // vuelve a empezar
        }
        else {
            teclado.close(); // cierra el scanner
        	System.exit(0); // cierra el programa
        }
    }

    // MÃ©todo para cambiar el mundo
    public void cambiarMundo() {
    	
    	//limpia la consola para mayor legibilidad
    	limpiarConsola();
    	
        if (this.mundos == Mundos.BOSQUE) {
            mundos = Mundos.TUNDRA;
            factoriaEnemigos = new Factoria_Tundra();
        } else if (this.mundos == Mundos.TUNDRA) {
            mundos = Mundos.VOLCAN;
            factoriaEnemigos = new Factoria_Volcan();
        } else if (this.mundos == Mundos.VOLCAN) {
            mundos = Mundos.BOSQUE;
            factoriaEnemigos = new Factoria_Bosque();
        }
    }

    // MÃ©todo para crear al jugador
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

            switch (eleccion) {
                case 1:
                    boolean confirmacion = false; // Variable para controlar si el usuario está conforme
                    do {
                        danio = 1;
                        magia = 1;
                        armadura = 1;
                        velocidad = 1;
                        puntos = 25;
                        puntos_eleccion = 0;
                        System.out.println("\nDebes repartir los " + puntos + " puntos en las estadÃ­sticas:");
                        do {
                            System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia
                                    + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                            System.out.print("Daño: ");
                            puntos_eleccion = teclado.nextInt();
                        } while ((puntos - puntos_eleccion) < 0);

                        danio = puntos_eleccion;
                        puntos -= puntos_eleccion;

                        if (puntos > 0) {
                            System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia
                                    + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                            System.out.println("Puntos restantes: " + puntos);

                            do {
                                System.out.print("Magia: ");
                                puntos_eleccion = teclado.nextInt();
                            } while ((puntos - puntos_eleccion) < 0);

                            magia = puntos_eleccion;
                            puntos -= puntos_eleccion;

                            if (puntos > 0) {
                                System.out.println("\nDistribucion de puntos: Fuerza: " + danio + "; Magia: " + magia
                                        + "; Armadura: " + armadura + "; Velocidad: " + velocidad);
                                System.out.println("Puntos restantes: " + puntos);

                                do {
                                    System.out.print("Armadura: ");
                                    puntos_eleccion = teclado.nextInt();
                                } while ((puntos - puntos_eleccion) < 0);

                                armadura = puntos_eleccion;
                                puntos -= puntos_eleccion;

                                if (puntos > 0) {
                                    System.out.println("\nPuntos restantes para velocidad: " + puntos + "\n");
                                    velocidad = puntos;
                                    ExtraccionDeMetodo.imprimirDistribucionPuntosPersonalizado(danio, magia, armadura, velocidad);
                                }
                            }
                        }
                        // Confirmar si el usuario está de acuerdo con la distribución
                        System.out.print("\n¿Estás conforme con la distribución de puntos? (s/n): ");
                        char respuesta = teclado.next().charAt(0);
                        confirmacion = (respuesta == 's' || respuesta == 'S'); // Si la respuesta es 's' o 'S', se
                                                                               // confirma

                    } while (!confirmacion);
                    break;

                case 2:

                    do {
                        System.out.println("\nPersonajes disponibles:"
                                + "\n1. Caballero (Dano: 10, Magia: 1, Armadura: 8, Velocidad: 6)"
                                + "\n2. Tanque(Dano:5 , Magia: 1, Armadura: 15, Velocidad: 4)"
                                + "\n3. Mago(Dano: 2, Magia: 15, Armadura: 2, Velocidad: 6)"
                                + "\nSeleccion: ");

                        eleccion2 = teclado.nextInt();
                    } while (eleccion2 < 1 || eleccion2 > 3);
                    boolean confirmado2 = false;
                    do {
                        switch (eleccion2) {
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
        
                        ExtraccionDeMetodo.imprimirDistribucionPuntosClases(eleccion2, danio, magia, armadura, velocidad);
                        // Confirmar si el usuario está de acuerdo con la distribución
                        System.out.print("\n¿Estás listo para la aventura que te espera? (S/n): ");
                        char respuesta = teclado.next().charAt(0);
                        confirmado2 = (respuesta == 's' || respuesta == 'S'); // Si la respuesta es 's' o 'S', se
                                                                              // confirma

                    } while (!confirmado2);
                    break;

                default:
                    System.out.println("ERROR. Debes introducir una opcion valida.");
                    break;
            }
        } while (eleccion < 1 || eleccion > 2);
        limpiarConsola(); // limpiar consola para más legibilidad
        
        // Se crea la instancia del jugador con los atributos proporcionados
        jugador = Jugador.getInstancia(nombre, 100, danio, magia, armadura, velocidad);
        return jugador;
    }

    // MÃ©todo para mostrar informaciÃ³n del jugador
    private String mostrarJugador(Jugador jugador) {
        return "HP: " + jugador.getVida() + ", ATK: " + jugador.getFuerza() + ", DEF: " + jugador.getArmadura()
                + ", MAG: " + jugador.getMagia() + ", VEL: " + jugador.getVelocidad();
    }
    
    // Método para limpiar la consola
    private static void limpiarConsola() {
    		for(int i = 0; i < 50; i++)
    			System.out.println();
    }


    // MÃ©todo para jugar en un mundo especÃ­fico con un enemigo
    private void jugarMundo(Jugador jugador, Enemigo enemigo) {

        Scanner teclado = new Scanner(System.in);
        int eleccion = 0;

        // Bucle mientras el murciÃ©lago y el jugador estÃ©n vivos
        while (enemigo.getVida() > 0 && jugador.getVida() > 0) {
        	
            // Se muestra la informaciÃ³n del jugador y del murciÃ©lago
            System.out.println(jugador.getNombre() + " -> " + mostrarJugador(jugador));
            System.out.println(enemigo.getNombre() + " -> Hp: " + enemigo.getVida());
            enemigo.printAscii();

            // Se solicita la acciÃ³n al jugador
            System.out.println("Que quieres hacer:"
                    + "\n1. Atacar."
                    + "\n2. Magia."
                    + "\nEleccion: ");

            eleccion = teclado.nextInt();

        	//limpia la consola para mayor legibilidad
        	limpiarConsola();
        	
        	
            switch (eleccion) {
                case 1:
                    // Si la velocidad del jugador es mayor que la del murciÃ©lago, el jugador ataca
                    // primero
                    if (jugador.getVelocidad() > enemigo.getVelocidad()) {
                        calculadora.atacar_jugador(jugador, enemigo);
                        calculadora.atacar_enemigo(enemigo, jugador);
                    } else {
                        // Si la velocidad del murciÃ©lago es mayor, el murciÃ©lago ataca primero
                        calculadora.atacar_enemigo(enemigo, jugador);
                        calculadora.atacar_jugador(jugador, enemigo);
                    }
                    break;

                case 2:
                    System.out.println("Que quieres hacer:"
                            + "\n1. Curar."
                            + "\n2. Proteger."
                            + "\n3. Examinar enemigo."
                            + "\nEleccion: ");

                    eleccion = teclado.nextInt();
                    
                    switch (eleccion) {
                        case 1:
                            if (jugador.getVelocidad() > enemigo.getVelocidad()) {
                                calculadora.curar(jugador);
                                calculadora.atacar_enemigo(enemigo, jugador);
                            } else {
                                calculadora.atacar_enemigo(enemigo, jugador);
                                calculadora.curar(jugador);
                            }
                            break;

                        case 2:
                            if (jugador.getVelocidad() > enemigo.getVelocidad()) {
                                calculadora.Proteger(jugador);
                                calculadora.atacar_enemigo(enemigo, jugador);
                            } else {
                                calculadora.atacar_enemigo(enemigo, jugador);
                                calculadora.Proteger(jugador);
                            }
                            break;

                        case 3:
                            if (jugador.getVelocidad() > enemigo.getVelocidad()) {
                                calculadora.examinar_enemigo(jugador, enemigo);
                                calculadora.atacar_enemigo(enemigo, jugador);
                            } else {
                                calculadora.atacar_enemigo(enemigo, jugador);
                                calculadora.examinar_enemigo(jugador, enemigo);
                            }
                            break;
                    }

                    break;
            }

            // Si el jugador estÃ¡ en un estado diferente a "Normal", recibe daÃ±o
            if (!jugador.getEstado().nombreEstado().equals("Normal")) {
                calculadora.recibir_danio_estado(jugador);
            }
            
        }
    }

}
