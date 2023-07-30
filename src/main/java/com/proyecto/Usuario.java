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
            opcion = h.recibeChar("*****BIENVENIDO*****"
                    + "\nA. Registro(Necesario para poder jugar)"
                    + "\nB.  Login(Para usuarios previamente registrados)"
                    + "\nC. Jugar"
                    + "\nD. Reportes"
                    + "\nS. Salir");

            //Case Switch de la primera opcion de registro.
            switch (opcion) {

                case 'A':
                    h.imprimeMensaje( "*****Bienvenido a Sudoku!*****");
                    this.registro();
                    break;
                case 'B':
                    h.imprimeMensaje("*****BIENVENIDO*****");
                    this.inicioSesion();
            }

        } while (opcion != 'S');

    }

    //Metodo de Registro
    public void registro() {

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

        boolean formatoValido = false;

        while (!formatoValido) {
            String input = h.recibeString("Digite su numero de telefono (Formato: XXXXXXXX): ");
            if (input == null || input.trim().isEmpty()) {
                h.imprimeMensaje("Debe ingresar un número de teléfono.");
                continue;
            }

            try {
                telefono = h.recibeInt(input);
                formatoValido = validarFormatoTelefono(telefono);
                if (!formatoValido) {
                    h.imprimeMensaje("Formato de teléfono incorrecto. Vuelva a intentarlo.");
                }
            } catch (NumberFormatException e) {
                h.imprimeMensaje("Debe ingresar solo dígitos numéricos.");
            }
        }

        residencia = h.recibeString("Digite su lugar de residencia(Formato: Canton/Provincia/Pais): ");

        if (residencia.isEmpty()) {
            h.imprimeMensaje("Digite una residencia");
            while (true) {
                residencia = h.recibeString("Digite su lugar de residencia (Formato: Canton/Provincia/Pais): ");
                if (residencia == null || residencia.trim().isEmpty()) {
                    h.imprimeMensaje("Debe ingresar el lugar de residencia.");
                } else if (validarFormatoResidencia(residencia)) {

                    break;
                } else {
                    h.imprimeMensaje("Formato de residencia incorrecto. Vuelva a intentarlo.");

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
            h.imprimeMensaje("Datos guardados correctamente en " + NOMBRE_ARCHIVO);
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
        String usuarioIngresado = h.recibeString("Ingrese su nombre de usuario: ");
        String contrasenaIngresada = h.recibeString("Ingrese su contraseña: ");
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
                            h.imprimeMensaje("Inicio de sesión exitoso.");
                             
                            //A partir de aqui esta la opcion de eliminar los datos del usuario ya registrado (PEQUEÑA PRUEBA.......)
                            char decision = h.recibeString("Eliminar Datos del Usuario\nS. Si\nN. No").toUpperCase().charAt(0);
                            if (decision == 'S') {
                                try {
                                    FileWriter archivoVacio = new FileWriter(NOMBRE_ARCHIVO);
                                    archivoVacio.write("");

                                    archivoVacio.close();

                                    JOptionPane.showMessageDialog(null, "Datos borrados correctamente", "Borrado", JOptionPane.INFORMATION_MESSAGE);

                                } catch (IOException e) {
                                    JOptionPane.showMessageDialog(null, "Error al intentar borrar los datos", "Error", JOptionPane.ERROR_MESSAGE);

                                }
                            }
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
