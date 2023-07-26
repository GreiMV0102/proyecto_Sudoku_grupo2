package com.proyecto;

import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

public class Usuario {

    private String NOMBRE_ARCHIVO = "datosUsuario.txt";
    private String nombreCompleto;
    private String correoElectronico;
    private String fechaNacimiento;
    private String sexo;
    private String cedula;
    private String usuario;
    private String contrasena;
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
        this.contrasena = contrasena;
        this.NOMBRE_ARCHIVO = NOMBRE_ARCHIVO;
    }

    public String getNOMBRE_ARCHIVO() {
        return NOMBRE_ARCHIVO;
    }

    public void setNOMBRE_ARCHIVO(String NOMBRE_ARCHIVO) {
        this.NOMBRE_ARCHIVO = NOMBRE_ARCHIVO;
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

    //Nuevo metodo de menu.
    public void menu() {

        char opcion = ' ';

        do {

            //Generacion del menu de opciones principal.        
            opcion = JOptionPane.showInputDialog("*****BIENVENIDO*****"
                    + "\nA. Registro(Necesario para poder jugar)"
                    + "\nB.  Login(Para usuarios previamente registrados)"
                    + "\nC. Jugar"
                    + "\nD. Reportes"
                    + "\nS. Salir").toUpperCase().charAt(0);

            //Case Switch de la primera opcion de registro.
            switch (opcion) {

                case 'A':
                    JOptionPane.showMessageDialog(null, "*****Bienvenido a Sudoku!*****");
                    this.registro();
                    break;
                case 'B':
                    JOptionPane.showMessageDialog(null, "*****BIENVENIDO*****");
                    this.inicioSesion();
            }

        } while (opcion != 'S');

    }

    //Metodo de Registro
    public void registro() {

        nombreCompleto = JOptionPane.showInputDialog("Digite su nombre: ");
        while (nombreCompleto.isEmpty()) {
            nombreCompleto = JOptionPane.showInputDialog("Digite su nombre: ");
        }

        correoElectronico = JOptionPane.showInputDialog("Digite su correo electronico: ");
        while (correoElectronico.isEmpty()) {
            correoElectronico = JOptionPane.showInputDialog("Digite su correo electronico: ");
        }
        fechaNacimiento = JOptionPane.showInputDialog("Ingrese su fecha de nacimiento(Formato: Dia/Mes/Anio: ");
        // Mientras la fecha de nacimiento esté vacía o no cumpla con el formato correcto, seguir solicitándola
        while (fechaNacimiento.isEmpty() || !validarFormatoFecha(fechaNacimiento)) {
            fechaNacimiento = JOptionPane.showInputDialog("Fecha de nacimiento inválida. Ingrese su fecha de nacimiento (Formato: Día/Fecha/Año): ");
        }
        sexo = JOptionPane.showInputDialog("Genero"
                + "                         \n F"
                + "                         \n M");
        // Mientras el género ingresado no sea "F" o "M", seguir solicitándolo
        while (sexo == null || (!sexo.equalsIgnoreCase("F") && !sexo.equalsIgnoreCase("M"))) {
            JOptionPane.showMessageDialog(null, "Género inválido. Debe ingresar 'F' o 'M'.");
            sexo = JOptionPane.showInputDialog("Género: \n F \n M");
        }
        while (true) {
            cedula = JOptionPane.showInputDialog("Digite su numero de cedula (Incluyendo los ceros: XXXXXXXXX):");
            if (validarFormatoCedula(cedula)) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Formato de cedula incorrecto. Vuelva a intentarlo.");
            }
        }

        usuario = JOptionPane.showInputDialog("Digite su nombre de usuario: ");
        while (usuario.isEmpty()) {
            usuario = JOptionPane.showInputDialog("Digite su usuario: ");
        }

        contrasena = JOptionPane.showInputDialog("Digite una contrasena: ");
        while (contrasena.isEmpty()) {
            contrasena = JOptionPane.showInputDialog("Digite su contrasena: ");
        }

        boolean formatoValido = false;

        while (!formatoValido) {
            String input = JOptionPane.showInputDialog("Digite su numero de telefono (Formato: XXXXXXXX): ");
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número de teléfono.");
                continue;
            }

            try {
                telefono = Integer.parseInt(input);
                formatoValido = validarFormatoTelefono(telefono);
                if (!formatoValido) {
                    JOptionPane.showMessageDialog(null, "Formato de teléfono incorrecto. Vuelva a intentarlo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar solo dígitos numéricos.");
            }
        }

        residencia = JOptionPane.showInputDialog("Digite su lugar de residencia(Formato: Canton/Provincia/Pais): ");

        if (residencia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite una residencia");
            while (true) {
                residencia = JOptionPane.showInputDialog("Digite su lugar de residencia (Formato: Canton/Provincia/Pais): ");
                if (residencia == null || residencia.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar el lugar de residencia.");
                } else if (validarFormatoResidencia(residencia)) {

                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Formato de residencia incorrecto. Vuelva a intentarlo.");

                }

                
            }
        }
        //Escritura de los datos en .txt
                String[] inputs = new String[8];

                inputs[0] = "Nombre Completo: " + nombreCompleto;
                inputs[1] = "Correo Electronico: " + correoElectronico;
                inputs[2] = "Fecha de Nacimiento: " + fechaNacimiento;
                inputs[3] = "Genero: " + sexo;
                inputs[4] = "Usuario: " + usuario;
                inputs[5] = "Contrasena: " + contrasena;
                inputs[6] = "Telefono: " + telefono;
                inputs[7] = "Lugar de Residencia: " + residencia;

                

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
                    for (String dato : inputs) {
                        writer.write(dato);
                        writer.newLine(); // Agregar un salto de línea después de cada input
                    }
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente en " + NOMBRE_ARCHIVO);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al escribir en el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

    public static boolean validarFormatoTelefono(int telefono) {
        // Asegúrate de que el número de teléfono tenga exactamente 8 dígitos
        String telefonoStr = String.valueOf(telefono);
        return telefonoStr.length() == 8;
    }

    public static boolean validarFormatoResidencia(String residencia) {
        // Verifica que la residencia tenga el formato correcto (Canton/Provincia/Pais)
        String[] partes = residencia.split("/");
        return partes.length == 3;
    }

    public void inicioSesion() {
        String usuarioIngresado = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        String contrasenaIngresada = JOptionPane.showInputDialog("Ingrese su contraseña: ");
        boolean usuarioValido = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(": ");
                if (datos.length == 2) {
                    String nombreDato = datos[0];
                    String valorDato = datos[1];
                    if (nombreDato.equals("Usuario") && valorDato.equals(usuarioIngresado)) {
                        usuarioValido = true;
                    }
                    if (nombreDato.equals("Contrasena") && valorDato.equals(contrasenaIngresada)) {
                        if (usuarioValido) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre de usuario es correcto, pero la contraseña es incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        return;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Nombre de usuario y/o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
