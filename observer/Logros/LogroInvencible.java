package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;

public class LogroInvencible extends Logro {
    private int nivelArmadura;
    
    public LogroInvencible(int nivelArmadura) {
        super("Invencible", "Tu armadura ha alcanzado el nivel " + nivelArmadura + ".");
        this.nivelArmadura = nivelArmadura;
    }
    
    @Override
    protected void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos) {
        if (accion.equals("STAT_CHANGED") && jugador.getArmadura() >= nivelArmadura) {
            desbloquear();
        }
    }
}