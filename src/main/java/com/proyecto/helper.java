package com.proyecto;

import java.awt.TextArea;
import javax.swing.JOptionPane;

public class Helper {
    public int recibeInt(String mensaje) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }

    public char recibeChar(String mensaje) {
        return JOptionPane.showInputDialog(mensaje).toUpperCase().charAt(0);
    }

    public String recibeString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public void imprimeMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void imprimeMensaje(TextArea mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public boolean confirmarAccion(String mensaje) {
        int respuesta = JOptionPane.showConfirmDialog(null, mensaje, "Confirmar Acción", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public int elegirOpcion(String mensaje, String[] opciones) {
        return JOptionPane.showOptionDialog(null, mensaje, "Seleccionar Opción",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }

    public void mostrarMensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeInformacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
