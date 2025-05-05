package Observer.Administrador;

import java.util.ArrayList;
import java.util.List;

import Jugador.Jugador;
import Observer.Adaptador.JugadorObservable;
import Observer.Logros.*;

public class AdministradorLogros {
    private static AdministradorLogros instancia;
    private List<Logro> logros;
    private JugadorObservable jugadorObservable;
    
    private AdministradorLogros() {
        logros = new ArrayList<>();
        
        
        logros.add(new LogroMataMurcielagos(5));
        logros.add(new LogroMataMurcielagos(10));
        logros.add(new LogroMataMurcielagos(20));
        logros.add(new LogroExplorador(3));
        logros.add(new LogroSuperGuerrero(15));
        logros.add(new LogroSuperGuerrero(25));
        logros.add(new LogroInvencible(10));
        logros.add(new LogroMaestroElemental(3));
    }
    
    public static AdministradorLogros getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorLogros();
        }
        return instancia;
    }
    
    public void registrarJugador(Jugador jugador) {
        
        jugadorObservable = new JugadorObservable(jugador);
        
        
        for (Logro logro : logros) {
            jugadorObservable.agregarObservador(logro);
        }
    }
    
    public JugadorObservable getJugadorObservable() {
        return jugadorObservable;
    }
    
    public List<Logro> getLogrosDesbloqueados() {
        List<Logro> desbloqueados = new ArrayList<>();
        for (Logro logro : logros) {
            if (logro.estaDesbloqueado()) {
                desbloqueados.add(logro);
            }
        }
        return desbloqueados;
    }
    
    public List<Logro> getLogros() {
        return logros;
    }
    
    public void mostrarLogros() {
        System.out.println("\n=== LOGROS ===");
        for (Logro logro : logros) {
            String estado = logro.estaDesbloqueado() ? "[X]" : "[ ]";
            System.out.println(estado + " " + logro.getNombre() + ": " + logro.getDescripcion());
        }
        System.out.println("==============\n");
    }
}