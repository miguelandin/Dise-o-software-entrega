package Jugador;

import Estados.EstadoNormal;
import Estados.EstadoCongelado;
import Estados.EstadoEnvenenado;
import Estados.EstadoQuemado;
import Interfaces.EstadoJugador;

public class Jugador {

    private static Jugador instancia; // Instancia única del jugador

    // Atributos del jugador
    private String nombre;
    private int vida;
    private int fuerza;
    private int magia;
    private int armadura;
    private int velocidad;

    private EstadoJugador estado; // Estado actual del jugador

    // Constructor del jugador
    public Jugador(String nombre, int vida, int fuerza, int magia, int armadura, int velocidad) {
        super();
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.magia = magia;
        this.armadura = armadura;
        this.velocidad = velocidad;

        this.estado = new EstadoNormal(); // Establece el estado inicial del jugador como "Normal"
    }

    // Método para obtener la instancia única del jugador utilizando el patrón Singleton
    public static Jugador getInstancia(String nombre, int vida, int fuerza, int magia, int armadura, int velocidad) {
        if (instancia == null) {
            instancia = new Jugador(nombre, vida, fuerza, magia, armadura, velocidad);
        }
        return instancia;
    }

    // Métodos getter y setter para los atributos del jugador
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void getDanio(int danio) {
        if (danio > 0) {
            this.vida -= danio;
        }
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getMagia() {
        return magia;
    }

    public void setMagia(int magia) {
        this.magia = magia;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public EstadoJugador getEstado() {
        return estado;
    }

    public void setEstado(EstadoJugador estado) {
        this.estado = estado;
    }

    // Método para curar al jugador
    public void curar(int cantidad) {
        this.vida += cantidad;

        if (this.vida > 100) {
            this.vida = 100;
        }
    }

    // Método toString para imprimir información sobre el jugador
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", vida=" + vida + ", fuerza=" + fuerza + ", magia=" + magia
                + ", armadura=" + armadura + ", velocidad=" + velocidad + ", estado=" + estado + "]";
    }

}
