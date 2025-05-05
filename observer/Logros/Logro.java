package Observer.Logros;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;
import Observer.Interfaces.Observable;
import Observer.Interfaces.Observador;


public abstract class Logro implements Observador {
    protected String nombre;
    protected String descripcion;
    protected boolean desbloqueado;
    
    public Logro(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.desbloqueado = false;
    }
    
    @Override
    public void actualizar(Observable sujeto, String accion, Object datos) {
        if (!desbloqueado && sujeto instanceof JugadorObservable) {
            JugadorObservable jugadorObs = (JugadorObservable) sujeto;
            comprobarLogro(jugadorObs, jugadorObs.getJugador(), accion, datos);
        }
    }
    
    
    protected abstract void comprobarLogro(JugadorObservable jugadorObs, Jugador jugador, String accion, Object datos);
    
    
    protected void desbloquear() {
        if (!desbloqueado) {
            desbloqueado = true;
            System.out.println("¡LOGRO DESBLOQUEADO! - " + nombre + ": " + descripcion);
        }
    }
    
    
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public boolean estaDesbloqueado() {
        return desbloqueado;
    }
}