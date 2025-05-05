package Observer.Interfaces;

// Interfaz para observadores
public interface Observador {
    void actualizar(Observable sujeto, String accion, Object datos);
}