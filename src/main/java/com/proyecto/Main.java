/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Isaac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Juego J = new Juego();
        Usuario u = new Usuario();
        Helper h = new Helper();
        int opcion = -1;

        while (opcion != 0) {
            String input = JOptionPane.showInputDialog(
                "Seleccione una opción:\n" +
                "1. Generar Usuario\n" +
                "2. Jugar Sudoku\n" +
                "3. Administrar Usuario\n" +
                "0. Salir");

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    new Usuario();
                    break;
                case 2:
                    new Juego();
                    break;
                case 3:
                    u.administrarUsuario();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias jugar nuestro juego, hasta pronto!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción incorrecta.");
            }
        }
    }
}
        
        
       
            
    
    

