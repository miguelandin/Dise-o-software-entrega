package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;

public class LogroMataMurcielagos extends Logro {
    private int cantidad;
    
    public LogroMataMurcielagos(int cantidad) {
        super("Cazador de Murciélagos", "Has derrotado a " + cantidad + " murciélagos.");
        this.cantidad = cantidad;
    }
    
    @Override
    protected void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos) {
        if (accion.equals("ENEMIGO_MATADO")) {
            String nombreEnemigo = (String) datos;
            if (nombreEnemigo.contains("Murcielago") && jugadorObs.getEnemigosMatados() >= cantidad) {
                desbloquear();
            }
        }
    }
}