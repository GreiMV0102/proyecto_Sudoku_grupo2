package com.proyecto;

import javax.swing.JOptionPane;

public class Usuario {

    private String nombreCompleto;
    private String correoElectronico;
    private String fechaNacimiento;
    private String sexo;
    private String cedula;
    private String usuario;
    private int telefono;
    private String residencia;

    public Usuario() {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.cedula = cedula;
        this.usuario = usuario;
        this.telefono = telefono;
        this.residencia = residencia;
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

    //Nuevo metodo de menu.
    public void menu() {

        char opcion = ' ';

        do {

            //Generacion del menu de opciones principal.        
            opcion = JOptionPane.showInputDialog("*****BIENVENIDO*****"
                    + "\nA. Registro(Necesario para poder jugar)"
                    + "\nB. Jugar"
                    + "\nC. Reportes"
                    + "\nS. Salir").toUpperCase().charAt(0);

            //Case Switch de la primera opcion de registro.
            switch (opcion) {

                case 'A':
                    JOptionPane.showMessageDialog(null, "*****Bienvenido a Sudoku!*****");
                    this.registro();
            }

        } while (opcion != 'S');

    }

    //Metodo de Registro
    public void registro() {

        nombreCompleto = JOptionPane.showInputDialog("Digite su nombre: ");
        if (nombreCompleto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un nombre");

        }
        correoElectronico = JOptionPane.showInputDialog("Digite su correo electronico: ");
        if (correoElectronico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un correo electronico");
        }
        fechaNacimiento = JOptionPane.showInputDialog("Ingrese su fecha de nacimiento(Formato: Dia/Fecha/Anio/: ");
        if (fechaNacimiento.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite una fecha de nacimiento");
        }
        sexo = JOptionPane.showInputDialog("Genero --- M ---- F----");
        if (sexo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un genero");
        }

        cedula = JOptionPane.showInputDialog("Digite su numero de cedula(Formato: X-XXXX-XXXX):");
        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un numero de cedula");

        }
        usuario = JOptionPane.showInputDialog("Digite su nombre de usuario: ");
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite un nombre de usuario");

        }
        telefono = Integer.parseInt(JOptionPane.showInputDialog("Digite su numero de telefono: "));

        residencia = JOptionPane.showInputDialog("Digite su lugar de residencia(Formato: Canton/Provincia/Pais): ");
        if (residencia.isEmpty())
            JOptionPane.showMessageDialog(null, "Digite una residencia");
        
    }
}
