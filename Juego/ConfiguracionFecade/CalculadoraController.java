package ConfiguracionFecade;

import java.util.Random;
import java.util.Scanner;

import Estados.EstadoNormal;
import Interfaces.Enemigo;
import Interfaces.Murcielago;
import Jugador.Jugador;

// La clase CalculadoraController implementa la lógica para el combate entre el jugador y los enemigos
public class CalculadoraController {
    private static CalculadoraController instancia = new CalculadoraController();
    private Boolean protegido;
    private int protegido_turnos;

    // Constructor privado para aplicar el patrón Singleton
    private CalculadoraController(){
        protegido = false;
        protegido_turnos = 0;
    }

    // Método estático para obtener la instancia única del CalculadoraController
    public static CalculadoraController getInstancia() {
        return instancia;
    }

    // Método para que el enemigo ataque al jugador
    public void atacar_enemigo(Enemigo enemigo, Jugador jugador) {
        if(enemigo.getVida() > 0) {
            if(!protegido) {
                Random random = new Random();
                int ataque = random.nextInt(2) + 1;

                switch(ataque) {
                    case 1:
                        System.out.println(enemigo.getNombre() + " usó un ataque normal.");
                        jugador.getDanio((enemigo.getDanio() - jugador.getArmadura()));
                        break;
                    case 2:
                        System.out.println(enemigo.getNombre() + " usó un ataque especial.");
                        int aplicar_efecto = random.nextInt(10) + 1;
                        try {
                            aplicar_efecto += enemigo.estrategia().aumentarPosibilidadEfecto();
                        } catch (Exception e) {}

                        if(aplicar_efecto > 5) {
                            if(jugador.getEstado().nombreEstado().equals("Normal")) {
                                System.out.println("El jugador ha recibido el estado " + enemigo.estadoAplicable().nombreEstado());
                                jugador.setEstado(enemigo.estadoAplicable());
                            }
                        }

                        jugador.getDanio((enemigo.getDanio() - jugador.getArmadura()));
                        break;
                }

                if(jugador.getVida() <= 0) {
                    System.out.println("El jugador " + jugador.getNombre()+ " ha sido eliminado.");
                }
            } else {
                System.out.println("El jugador tiene el hechizo de protección");
                protegido_turnos--;

                if(protegido_turnos <= 0) {
                    protegido = false;
                }
            }

        }
    }

    // Método para recibir daño del estado del jugador
    public void recibir_danio_estado(Jugador jugador) {
        if(jugador.getEstado().numTurnos() > 0) {
            if(jugador.getEstado().nombreEstado() == "Envenenado") {
                System.out.println(jugador.getNombre() + " ha sido dañado por su estado envenenado.");
                jugador.getDanio(jugador.getEstado().danioEstado());
            } else if(jugador.getEstado().nombreEstado() == "Quemado") {
                System.out.println(jugador.getNombre() + " ha sido dañado por su estado quemado.");
                jugador.getDanio(jugador.getEstado().danioEstado());
            }
            jugador.getEstado().reducirTurnos();
        } else {
            jugador.setEstado(new EstadoNormal());
        }

    }

    // Método para que el jugador ataque al enemigo
    public void atacar_jugador(Jugador jugador, Enemigo enemigo) {
        if(jugador.getVida() > 0) {
            if(jugador.getEstado().nombreEstado().equals("Congelado")) {
                System.out.println("El jugador está congelado");
            } else {
                System.out.println(jugador.getNombre() + " atacó al enemigo.");
                enemigo.recibirAtaque(jugador.getFuerza());
            }

            if(enemigo.getVida() <= 0) {
                System.out.println("El enemigo " + enemigo.getNombre()+ " ha sido eliminado.");
                aumentar_stats(jugador, enemigo.getPuntos());
            }
        }
    }

    // Método para aumentar las estadísticas del jugador
    public void aumentar_stats(Jugador jugador, int puntos) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Tienes " + puntos + " puntos para repartir en tus estadísticas: ");
        int puntos_eleccion = 0;
        do {
            System.out.print("Daño: ");
            puntos_eleccion = teclado.nextInt();
        } while((puntos - puntos_eleccion) < 0);

        jugador.setFuerza(jugador.getFuerza() + puntos_eleccion);
        puntos -= puntos_eleccion;

        if(puntos > 0) {
            System.out.println("\nPuntos restantes: " + puntos);

            do {
                System.out.print("Magia: ");
                puntos_eleccion = teclado.nextInt();
            } while((puntos - puntos_eleccion) < 0);

            jugador.setMagia(jugador.getMagia() + puntos_eleccion);
            puntos -= puntos_eleccion;

            if(puntos > 0) {
                System.out.println("\nPuntos restantes: " + puntos);

                do {
                    System.out.print("Armadura: ");
                    puntos_eleccion = teclado.nextInt();
                } while((puntos - puntos_eleccion) < 0);

                jugador.setArmadura(jugador.getArmadura() + puntos_eleccion);
                puntos -= puntos_eleccion;

                if(puntos > 0) {
                    System.out.println("\nPuntos restantes para velocidad: " + puntos);
                    jugador.setVelocidad(jugador.getVelocidad() + puntos_eleccion);
                }
            }
        }
    }

    // Método para curar al jugador
    public void curar(Jugador jugador) {
        if(jugador.getVida() > 0 ) {
            System.out.println("El jugador se ha curado " + (10 + jugador.getMagia()) + " puntos de vida.");
            jugador.curar(10 + jugador.getMagia());
        }
    }

    // Método para proteger al jugador
    public void Proteger(Jugador jugador) {
        if(jugador.getVida() > 0 ) {
            if(jugador.getMagia() > 6) {
                System.out.println("El jugador se ha colocado una protección.");
                protegido_turnos = 3;
                protegido = true;
            } else {
                System.out.println("No tienes suficiente magia para usarlo.");
            }
        }
    }

    // Método para examinar al enemigo
    public void examinar_enemigo(Jugador jugador, Murcielago murcielago) {
        if(jugador.getVida() > 0 ) {
            System.out.println(murcielago.toString());
        }
    }
}
