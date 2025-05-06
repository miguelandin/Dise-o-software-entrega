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

        System.out.println("--- BIENVENIDO A RPGLAND ---");
        System.out.println("Antes de comenzar la aventura, pasaremos a la creaciÃ³n de tu personaje: ");

        // Se crea el jugador
        Jugador jugador = crearJugador(teclado);
        Murcielago murcielago;

        // Se crea el primer enemigo (murciÃ©lago)
        murcielago = factoriaEnemigos.crearMurcielago();

        // Bucle principal del juego, mientras el jugador tenga vida
        while (jugador.getVida() > 0) {
            // Se verifica si el jugador estÃ¡ vivo antes de cada acciÃ³n
            if (jugador.getVida() > 0)
                System.out.println("MUNDO: " + mundos.getNombre());

            // Se juega en el mundo actual
            if (jugador.getVida() > 0)
                jugarMundo(jugador, murcielago);

            // Se cambia al siguiente mundo
            if (jugador.getVida() > 0)
                cambiarMundo();

            // Se verifica si el jugador estÃ¡ vivo despuÃ©s de cambiar de mundo
            if (jugador.getVida() > 0)
                System.out.println("MUNDO: " + mundos.getNombre());

            // Se crea un nuevo murciÃ©lago para el prÃ³ximo encuentro
            if (jugador.getVida() > 0)
                murcielago = factoriaEnemigos.crearMurcielago();

            // Se juega en el nuevo mundo con el nuevo enemigo
            if (jugador.getVida() > 0)
                jugarMundo(jugador, murcielago);

            // Se cambia al siguiente mundo nuevamente
            if (jugador.getVida() > 0)
                cambiarMundo();

            // Se repite el bucle, mejorando enemigos
            if (jugador.getVida() > 0)
                System.out.println("Se repite el bucle, mejorando enemigos");
        }

        System.out.println("El jugador ha perdido.");

        teclado.close();
    }

    // MÃ©todo para cambiar el mundo
    public void cambiarMundo() {
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
                                    // pergamino de stats
                                    System.out.println("         _______________________________");
                                    System.out.println("       / \\                              \\.");
                                    System.out.println("      |   |                             |.");
                                    System.out.println("       \\_/|  » DISTRIBUCIÓN DE PUNTOS « |.");
                                    System.out.println("          |                             |.");
                                    if (danio > 9) {
                                        System.out.println("          |  » Daño: " + danio + "                 |.");
                                    } else {
                                        System.out.println("          |  » Daño: " + danio + "                  |.");
                                    }
                                    System.out.println("          |                             |.");
                                    if (magia > 9) {
                                        System.out.println("          |  » Magia: " + magia + "                |.");
                                    } else {
                                        System.out.println("          |  » Magia: " + magia + "                 |.");
                                    }
                                    System.out.println("          |                             |.");
                                    if (armadura > 9) {
                                        System.out.println("          |  » Armadura: " + armadura + "             |.");
                                    } else {
                                        System.out.println("          |  » Armadura: " + armadura + "              |.");
                                    }
                                    System.out.println("          |                             |.");
                                    if (velocidad > 9) {
                                        System.out.println("          |  » Velocidad: " + velocidad + "            |.");
                                    } else {
                                        System.out
                                                .println("          |  » Velocidad: " + velocidad + "             |.");
                                    }
                                    System.out.println("          |                             |.");
                                    System.out.println("          |   __________________________|__");
                                    System.out.println("          |  /                            /.");
                                    System.out.println("          \\_/____________________________/.");
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
                                + "\n1. Caballero (DaÃ±o: 10, Magia: 1, Armadura: 8, Velocidad: 6)"
                                + "\n2. Tanque(DaÃ±o:5 , Magia: 1, Armadura: 15, Velocidad: 4)"
                                + "\n3. Mago(DaÃ±o: 2, Magia: 15, Armadura: 2, Velocidad: 6)"
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
                        // pergamino de stats
                        System.out.println("         _______________________________");
                        System.out.println("       / \\                              \\.");
                        System.out.println("      |   |                             |.");
                        System.out.println("       \\_/|  » DISTRIBUCIÓN DE PUNTOS « |.");
                        System.out.println("          |                             |.");
                        if (eleccion2 == 1) {
                            System.out.println("          |  » Daño: " + danio + "                 |.");
                        } else {
                            System.out.println("          |  » Daño: " + danio + "                  |.");
                        }
                        System.out.println("          |                             |.");
                        if (eleccion2 == 3) {
                            System.out.println("          |  » Magia: " + magia + "                |.");
                        } else {
                            System.out.println("          |  » Magia: " + magia + "                 |.");
                        }
                        System.out.println("          |                             |.");
                        if (eleccion2 == 2) {
                            System.out.println("          |  » Armadura: " + armadura + "             |.");
                        } else {
                            System.out.println("          |  » Armadura: " + armadura + "              |.");
                        }
                        System.out.println("          |                             |.");
                        System.out.println("          |  » Velocidad: " + velocidad + "             |.");
                        System.out.println("          |                             |.");
                        System.out.println("          |   __________________________|__");
                        System.out.println("          |  /                            /.");
                        System.out.println("          \\_/____________________________/.");
                        // Confirmar si el usuario está de acuerdo con la distribución
                        System.out.print("\n¿Estás listo para la aventura que te espera? (s/n): ");
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

        // Se crea la instancia del jugador con los atributos proporcionados
        jugador = Jugador.getInstancia(nombre, 100, danio, magia, armadura, velocidad);

        return jugador;
    }

    // MÃ©todo para mostrar informaciÃ³n del jugador
    private String mostrarJugador(Jugador jugador) {
        return "HP: " + jugador.getVida() + ", ATK: " + jugador.getFuerza() + ", DEF: " + jugador.getArmadura()
                + ", MAG: " + jugador.getMagia() + ", VEL: " + jugador.getVelocidad();
    }

    // MÃ©todo para jugar en un mundo especÃ­fico con un enemigo
    private void jugarMundo(Jugador jugador, Murcielago murcielago) {

        Scanner teclado = new Scanner(System.in);

        int eleccion = 0;

        // Bucle mientras el murciÃ©lago y el jugador estÃ©n vivos
        while (murcielago.getVida() > 0 && jugador.getVida() > 0) {

            // Se muestra la informaciÃ³n del jugador y del murciÃ©lago
            System.out.println(jugador.getNombre() + " -> " + mostrarJugador(jugador));
            System.out.println(murcielago.getNombre() + " ->" + murcielago.getVida());
            murcielago.printAscii();

            // Se solicita la acciÃ³n al jugador
            System.out.println("Que quieres hacer:"
                    + "\n1. Atacar."
                    + "\n2. Magia."
                    + "\nEleccion: ");

            eleccion = teclado.nextInt();

            switch (eleccion) {
                case 1:
                    // Si la velocidad del jugador es mayor que la del murciÃ©lago, el jugador ataca
                    // primero
                    if (jugador.getVelocidad() > murcielago.getVelocidad()) {
                        calculadora.atacar_jugador(jugador, murcielago);
                        calculadora.atacar_enemigo(murcielago, jugador);
                    } else {
                        // Si la velocidad del murciÃ©lago es mayor, el murciÃ©lago ataca primero
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

                    switch (eleccion) {
                        case 1:
                            if (jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.curar(jugador);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            } else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.curar(jugador);
                            }
                            break;

                        case 2:
                            if (jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.Proteger(jugador);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            } else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.Proteger(jugador);
                            }
                            break;

                        case 3:
                            if (jugador.getVelocidad() > murcielago.getVelocidad()) {
                                calculadora.examinar_enemigo(jugador, murcielago);
                                calculadora.atacar_enemigo(murcielago, jugador);
                            } else {
                                calculadora.atacar_enemigo(murcielago, jugador);
                                calculadora.examinar_enemigo(jugador, murcielago);
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
