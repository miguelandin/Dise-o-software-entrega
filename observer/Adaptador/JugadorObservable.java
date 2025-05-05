
// Clase adaptadora que convierte el Jugador en un Observable


package Observer.Adaptador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Jugador.Jugador;
import Observer.Interfaces.Observable;
import Observer.Interfaces.Observador;


public class JugadorObservable implements Observable {
    private Jugador jugador;
    private List<Observador> observadores = new ArrayList<>();
    
    // Estadísticas para los logros
    private int enemigosMatados;
    private Set<String> mundosVisitados;
    private int cambiosMundo;
    private int estadosSuperados;
    
    public JugadorObservable(Jugador jugador) {
        this.jugador = jugador;
        this.enemigosMatados = 0;
        this.mundosVisitados = new HashSet<>();
        this.mundosVisitados.add("BOSQUE"); 
        this.cambiosMundo = 0;
        this.estadosSuperados = 0;
    }
    
    @Override
    public void agregarObservador(Observador o) {
        if (!observadores.contains(o)) {
            observadores.add(o);
        }
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String accion, Object datos) {
        for (Observador observador : observadores) {
            observador.actualizar(this, accion, datos);
        }
    }
    
    
    public void registrarEnemigoMatado(String nombreEnemigo) {
        enemigosMatados++;
        notificarObservadores("ENEMIGO_MATADO", nombreEnemigo);
    }
    
    public void registrarCambioMundo(String nombreMundo) {
        cambiosMundo++;
        mundosVisitados.add(nombreMundo);
        notificarObservadores("CAMBIO_MUNDO", nombreMundo);
    }
    
    public void registrarEstadoSuperado(String nombreEstado) {
        estadosSuperados++;
        notificarObservadores("ESTADO_SUPERADO", nombreEstado);
    }
    
    public void registrarCambioEstadistica(String estadistica) {
        notificarObservadores("STAT_CHANGED", estadistica);
    }
    
    
    public int getEnemigosMatados() {
        return enemigosMatados;
    }
    
    public int getMundosVisitados() {
        return mundosVisitados.size();
    }
    
    public int getCambiosMundo() {
        return cambiosMundo;
    }
    
    public int getEstadosSuperados() {
        return estadosSuperados;
    }
    
    
    public Jugador getJugador() {
        return jugador;
    }
}