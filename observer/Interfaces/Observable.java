package Observer.Interfaces;

// Interfaz para objetos observables
public interface Observable {
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores(String accion, Object datos);
}