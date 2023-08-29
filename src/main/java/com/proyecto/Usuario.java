package com.proyecto;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.*;

import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class Usuario {

    private static Usuario[] usuarios = new Usuario[100];
    private static int cantidadUsuarios = 0;
    private static final int capacidadMaxima = 100;

    private String nombreCompleto;
    private String correoElectronico;
    private String fechaNacimiento;
    private String sexo;
    private String cedula;
    private String usuario;
    private String contrasena;
    private int telefono;
    private String residencia;

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

    Helper h = new Helper();

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

        pedirDatos();
        agregarUsuario(this);
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


    private void pedirDatos() {
        nombreCompleto = h.recibeString("Nombre completo:");
        correoElectronico = h.recibeString("Correo electrónico:");
        fechaNacimiento = h.recibeString("Fecha de nacimiento:");
        sexo = h.recibeString("Sexo:");
        cedula = h.recibeString("Cédula:");
        usuario = h.recibeString("Usuario:");
        contrasena = h.recibeString("Contraseña:");
        telefono = (h.recibeInt("Teléfono:"));
        residencia = JOptionPane.showInputDialog("Residencia:");
    }

    public void agregarUsuario(Usuario nuevoUsuario) {
        if (cantidadUsuarios < capacidadMaxima) {
            usuarios[cantidadUsuarios] = nuevoUsuario;
            cantidadUsuarios++;
            JOptionPane.showMessageDialog(null, "Usuario agregado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más usuarios, capacidad máxima alcanzada.");
        }
    }

    public void editarUsuario(){
        String nuevoValor = JOptionPane.showInputDialog("Ingrese el nuevo valor:");

        if (nuevoValor != null && !nuevoValor.isEmpty()) {
            
            String campoEditar = JOptionPane.showInputDialog(
                "Seleccione el campo a editar:\n" +
                "1. Nombre completo\n" +
                "2. Correo electrónico\n" +
                "3. Fecha de nacimiento\n" +
                "4. Sexo\n" +
                "5. Cédula\n" +
                "6. Contraseña\n" +
                "7. Teléfono\n" +
                "8. Residencia"
            );

            switch (campoEditar) {
                case "1":
                    nombreCompleto = nuevoValor;
                    break;
                case "2":
                    correoElectronico = nuevoValor;
                    break;
                case "3":
                    fechaNacimiento = nuevoValor;
                    break;
                case "4":
                    sexo = nuevoValor;
                    break;
                case "5":
                    cedula = nuevoValor;
                    break;
                case "6":
                    contrasena = nuevoValor;
                    break;
                case "7":
                    telefono = Integer.parseInt(nuevoValor);
                    break;
                case "8":
                    residencia = nuevoValor;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
            
            JOptionPane.showMessageDialog(null, "Campo editado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El valor no puede estar vacío.");
        }
    }

    public static void mostrarUsuarios(Usuario[] usuarios) {
        String usuariosInfo = "";

        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null) {
                usuariosInfo += "Usuario " + (i + 1) + ":\t";
                usuariosInfo += usuarios[i].toString() + "\t\t";
            }
        }

        JOptionPane.showMessageDialog(null, usuariosInfo, "Usuarios Registrados", JOptionPane.PLAIN_MESSAGE);
    }
        
 
       public static void eliminarUsuario(Usuario[] usuarios) {
        String usuarioAEliminar = JOptionPane.showInputDialog("Ingrese el usuario que desea eliminar:");

        for (int i = 0; i < cantidadUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsuario().equals(usuarioAEliminar)) {
                usuarios[i] = null;
                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente.");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
    }
        
    
    public void administrarUsuario() {
        int opcion = -1;

        while (opcion != 3) {
            String input = JOptionPane.showInputDialog(
                "Seleccione una opción:\n" +
                "1. Editar Usuario\n" +
                "2. Eliminar Usuario\n" +
                "3. Mostrar Usuarios\n"
               +"4. Volver al menu");

            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    this.editarUsuario();
                    break;
                case 2:
                    this.eliminarUsuario(usuarios);
                    break;
                case 3:
                    this.mostrarUsuarios(usuarios);
                    break;
                case 4:
                    
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
