package com.proyecto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TiempoJuego {
    private LocalDateTime fecha;
    private Usuario usuario;
    private Nivel nivel;    
    private long tiempoEnSegundos;

    public TiempoJuego(Usuario usuario, Nivel nivel, long tiempoEnSegundos) {
        this.fecha = LocalDateTime.now();
        this.usuario = usuario;
        this.nivel = nivel;
        this.tiempoEnSegundos = tiempoEnSegundos;
    }

    // Getters y Setters

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public long getTiempoEnSegundos() {
        return tiempoEnSegundos;
    }

    public void setTiempoEnSegundos(long tiempoEnSegundos) {
        this.tiempoEnSegundos = tiempoEnSegundos;
    }

    // Obtener la fecha y hora actual
    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    // Método para mostrar la información del tiempo de juego 
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = fecha.format(formatter);
        return "Usuario: " + usuario.getNombreCompleto() + ", Nivel: " + nivel.getNombre() + ", Tiempo: " + tiempoEnSegundos + " segundos, Fecha: " + formattedDate;
    }
}
