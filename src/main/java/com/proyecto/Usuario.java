package com.proyecto;
import javax.swing.JOptionPane;
public class Usuario {
    
    private String nombreCompleto;
    private String correoElectronico;
    private String fechaNacimiemto;
    private char sexo;
    private int cedula;
    private String usuario;
    private int telefono;
    private String residencia;

    public Usuario() {
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiemto = fechaNacimiemto;
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
        return fechaNacimiemto;
    }

    public void setFechaNacimiemto(String fechaNacimiento) {
        this.fechaNacimiemto = fechaNacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setSexo(char sexo) {
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

    public void datosDeUsuario() {
        do {
            nombreCompleto = JOptionPane.showInputDialog("Ingrese su nombre completo");
            if (nombreCompleto.equals(" ") || nombreCompleto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre invalido\nIntente nuevamente");
            } else {
                JOptionPane.showMessageDialog(null, "Nombre ingresado correctamente");
            }
            
            correoElectronico = JOptionPane.showInputDialog("Ingrese su correo electronico");
            if(correoElectronico.endsWith(" ") || correoElectronico.isEmpty()){
                JOptionPane.showMessageDialog(null, "Correo electronico invalido\nIntente nuevamente");
            }else{
                JOptionPane.showMessageDialog(null, "Correo electronico ingresado correctamente");
            }
        } while (nombreCompleto.isEmpty() && correoElectronico.isEmpty());
        
        
        while (cedula <= 0) {
            cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su numero de identificacion"));
            if (cedula <= 0) {
                JOptionPane.showMessageDialog(null, "Identificacion invalida\nIntente nuevamente");
            } else {
                JOptionPane.showMessageDialog(null, "Identificacion valida");
                break;
            }
        }
        
        int dia= 0, mes= 0, anio= 0;
        
        JOptionPane.showMessageDialog(null, "Digite su fecha de nacimiento a continuacion");
        do{
            dia = Integer.parseInt(JOptionPane.showInputDialog("Dia"));
            mes = Integer.parseInt(JOptionPane.showInputDialog("Mes"));
            anio = Integer.parseInt(JOptionPane.showInputDialog("Anio"));
            
            fechaNacimiemto = +dia+" / "+mes+" / "+anio;

            if(dia <= 31 && mes <= 12 && anio > 0){
                JOptionPane.showMessageDialog(null,"Fecha de nacimiento ingresado correctamente\n "+dia+" / "+mes+" / "+anio);
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Fecha de nacimiento incorrecta\nFavor intente nuevamente");
            }
            
        }while(dia <= 31 || mes <= 12 || anio > 0);
    }
    
    
}
