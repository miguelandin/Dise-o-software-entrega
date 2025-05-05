package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;

public class LogroMaestroElemental extends Logro {
    private int cantidad;
    
    public LogroMaestroElemental(int cantidad) {
        super("Maestro Elemental", "Has sobrevivido a " + cantidad + " estados elementales.");
        this.cantidad = cantidad;
    }
    
    @Override
    protected void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos) {
        if (accion.equals("ESTADO_SUPERADO") && jugadorObs.getEstadosSuperados() >= cantidad) {
            desbloquear();
        }
    }
}