package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;

public class LogroSuperGuerrero extends Logro {
    private int nivelFuerza;
    
    public LogroSuperGuerrero(int nivelFuerza) {
        super("Super Guerrero", "Tu fuerza ha alcanzado el nivel " + nivelFuerza + ".");
        this.nivelFuerza = nivelFuerza;
    }
    
    @Override
    protected void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos) {
        if (accion.equals("STAT_CHANGED") && jugador.getFuerza() >= nivelFuerza) {
            desbloquear();
        }
    }
}