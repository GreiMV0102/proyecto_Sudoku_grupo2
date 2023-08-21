package com.proyecto;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class Usuario {

    private String nombreCompleto;
    private String correoElectronico;
    private String fechaNacimiento;
    private String sexo;
    private String cedula;
    private String usuario;
    private String contrasena;
    private int telefono;
    private String residencia;
    
    MenuPrincipal menu;

    public Usuario(String nombreCompleto, String correoElectronico, String fechaNacimiento, String sexo, String cedula, String usuario, String contrasena, int telefono, String residencia) {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.cedula = cedula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.residencia = residencia;
    }

    helper h = new helper();

    public Usuario() {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.cedula = cedula;
        this.usuario = usuario;
        this.telefono = telefono;
        this.residencia = residencia;
        this.contrasena = contrasena;

    }

    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getFechaNacimiemto() {
        return fechaNacimiento;
    }

    public void setFechaNacimiemto(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    @Override
    public String toString() {
        return nombreCompleto + "\t" + correoElectronico + "\t" + fechaNacimiento + "\t" + sexo + "\t" + cedula + "\t" + usuario + "\t" + contrasena + "\t" + telefono + "\t" + residencia;
    }

   public void agregarUsuario(Usuario usuarios[]) {

        nombreCompleto = h.recibeString("Digite su nombre: ");
        while (nombreCompleto.isEmpty()) {
            nombreCompleto = h.recibeString("Digite su nombre: ");
        }

        correoElectronico = h.recibeString("Digite su correo electronico: ");
        while (correoElectronico.isEmpty()) {
            correoElectronico = h.recibeString("Digite su correo electronico: ");
        }
        fechaNacimiento = h.recibeString("Ingrese su fecha de nacimiento(Formato: Dia/Mes/Anio: ");
        // Mientras la fecha de nacimiento esté vacía o no cumpla con el formato correcto, seguir solicitándola
        while (fechaNacimiento.isEmpty() || !validarFormatoFecha(fechaNacimiento)) {
            fechaNacimiento = h.recibeString("Fecha de nacimiento inválida. Ingrese su fecha de nacimiento (Formato: Día/Fecha/Año): ");
        }
        sexo = h.recibeString("Genero"
                + "                         \n F"
                + "                         \n M");
        // Mientras el género ingresado no sea "F" o "M", seguir solicitándolo
        while (sexo == null || (!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M"))) {
            h.imprimeMensaje("Género inválido. Debe ingresar 'F' o 'M'.");
            sexo = h.recibeString("Género: \n F \n M");
        }
        while (true) {
            cedula = h.recibeString("Digite su numero de cedula (Incluyendo los ceros: XXXXXXXXX):");
            if (validarFormatoCedula(cedula)) {
                break;
            } else {
                h.imprimeMensaje("Formato de cedula incorrecto. Vuelva a intentarlo.");
            }
        }

        usuario = h.recibeString("Digite su nombre de usuario: ");
        while (usuario.isEmpty()) {
            usuario = h.recibeString("Digite su usuario: ");
        }

        contrasena = h.recibeString("Digite una contrasena: ");
        while (contrasena.isEmpty()) {
            contrasena = h.recibeString("Digite su contrasena: ");
        }

        telefono = h.recibeInt("Digite su numero de telefono: ");
        while (contrasena.isEmpty()) {
            contrasena = h.recibeString("Digite su contrasena: ");
        }

        residencia = h.recibeString("Digite su lugar de residencia(Formato: Canton/Provincia/Pais): ");
        int index = -1;
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                index = i;
                break;
            }
            
        }
        
        if (index != -1){
            usuarios[index] = new Usuario( nombreCompleto,  correoElectronico,  fechaNacimiento,  sexo,  cedula,  usuario,  contrasena,  telefono,  residencia);
        }else{
            h.imprimeMensaje("No hay espacios disponibles para nuevos usuarios");
        }    
        
    }
    
// Validar Formato de la Fecha

    public static boolean validarFormatoFecha(String fecha) {
        // Expresión regular para el formato de fecha "Día/Fecha/Año"
        String regex = "^\\d{1,2}/\\d{1,2}/\\d{4}$";

        // Verificar si la fecha coincide con el formato
        return fecha.matches(regex);
    }

    public static boolean validarFormatoCedula(String cedula) {
        // Asegúrate de que la cedula tenga exactamente 9 caracteres
        if (cedula == null || cedula.length() != 9) {
            return false;
        }

        // Verifica que todos los caracteres sean dígitos numéricos
        for (int i = 0; i < 9; i++) {
            char ch = cedula.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validarFormatoResidencia(String residencia) {
        // Verifica que la residencia tenga el formato correcto (Canton/Provincia/Pais)
        String[] partes = residencia.split("/");
        return partes.length == 3;
    }

    public Usuario[] generarListaUsuarios() {
        helper h = new helper();
        int tamano = h.recibeInt("Digite la cantidad de usuarios que desea agregar: ");
        Usuario usuarios[] = new Usuario[tamano];
        return usuarios;
    }

}
