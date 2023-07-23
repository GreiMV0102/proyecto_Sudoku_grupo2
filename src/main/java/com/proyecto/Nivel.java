/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto;

/**
 *
 * @author Usuario
 */

public class Nivel {
    private String nombre;
    private int pistas;
    private int cantidadNumerosMostrados;
    private int cantidadNumerosCuadro;
    private int cantidadNumerosFilaColumna;

    public Nivel(String nombre, int pistas, int cantidadNumerosMostrados, int cantidadNumerosCuadro, int cantidadNumerosFilaColumna) {
        this.nombre = nombre;
        this.pistas = pistas;
        this.cantidadNumerosMostrados = cantidadNumerosMostrados;
        this.cantidadNumerosCuadro = cantidadNumerosCuadro;
        this.cantidadNumerosFilaColumna = cantidadNumerosFilaColumna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPistas() {
        return pistas;
    }

    public void setPistas(int pistas) {
        this.pistas = pistas;
    }

    public int getCantidadNumerosMostrados() {
        return cantidadNumerosMostrados;
    }

    public void setCantidadNumerosMostrados(int cantidadNumerosMostrados) {
        this.cantidadNumerosMostrados = cantidadNumerosMostrados;
    }

    public int getCantidadNumerosCuadro() {
        return cantidadNumerosCuadro;
    }

    public void setCantidadNumerosCuadro(int cantidadNumerosCuadro) {
        this.cantidadNumerosCuadro = cantidadNumerosCuadro;
    }

    public int getCantidadNumerosFilaColumna() {
        return cantidadNumerosFilaColumna;
    }

    public void setCantidadNumerosFilaColumna(int cantidadNumerosFilaColumna) {
        this.cantidadNumerosFilaColumna = cantidadNumerosFilaColumna;
    }
}
