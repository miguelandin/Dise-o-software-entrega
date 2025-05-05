package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;

public class LogroExplorador extends Logro {
    private int cantidadMundos;
    
    public LogroExplorador(int cantidadMundos) {
        super("Explorador", "Has visitado " + cantidadMundos + " mundos diferentes.");
        this.cantidadMundos = cantidadMundos;
    }
    
    @Override
    protected void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos) {
        if (accion.equals("CAMBIO_MUNDO") && jugadorObs.getMundosVisitados() >= cantidadMundos) {
            desbloquear();
        }
    }
}