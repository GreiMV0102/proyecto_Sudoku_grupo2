
package com.proyecto;

import java.time.LocalDateTime;

public class tiempojuego {
     private LocalDateTime fecha;
    private String nivel;
    private String tiempo;

    public tiempojuego(LocalDateTime fecha, String nivel, String tiempo) {
        this.fecha = fecha;
        this.nivel = nivel;
        this.tiempo = tiempo;
    }

    // Getters y Setters
    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    
    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }

    
}
