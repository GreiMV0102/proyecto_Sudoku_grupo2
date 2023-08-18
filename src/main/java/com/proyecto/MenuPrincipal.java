package com.proyecto;

public class MenuPrincipal {

    //Nuevo metodo de menu.
    public void menuPrincipalJuego() {
        helper h = new helper();
        Usuario usuarios[] = new Usuario[0];
        int poscUsuario = 0;
        Usuario U = new Usuario();
        boolean listaUsuario = false;

        char opcion = ' ';

        do {

            //Generacion del menu de opciones principal.        
            opcion = h.recibeChar("*****BIENVENIDO*****"
                    + "\nA. Creacion y Modificacion de Usuarios"
                    + "\nB. Jugar"
                    + "\nC. Reportes"
                    + "\nS. Salir");

            //Case Switch de la primera opcion de registro.
            switch (opcion) {

                case 'A':
                    h.imprimeMensaje("*****Bienvenido a Sudoku!*****");
                    this.menuUsuario();
                    break;
                case 'B':

                    break;

                case 'C':
                    Juego sudoku = new Juego();
                    sudoku.mostrarSudoku();
                    break;

            }

        } while (opcion != 'S');

    }
    
     //Metodo de Registro
    public void menuUsuario() {
        helper h = new helper();
        Usuario usuarios[] = new Usuario[0];
        int poscUsuario = 0;
        Usuario U = new Usuario();
        boolean listaUsuario = false;

        char opcion = ' ';
        do {

            opcion = h.recibeChar("*****BIENVENIDO*****"
                    + "\nA. Generar lista de Usuarios"
                    + "\nB. Agregar Usuario"
                    + "\nC. Modificar Usuario"
                    + "\nD. Eliminar Usuario"
                    + "\nE. Buscar Usuario"
                    + "\nF. Listar Usuario"
                    + "\nG. Ver Juegos"//Tentativo

                    + "\nS. Volver");

            switch (opcion) {

                case 'A':
                    usuarios = U.generarListaUsuarios();
                    listaUsuario = true;
                    break;

                case 'B':
                    if (listaUsuario) {
                        if (poscUsuario < usuarios.length) {
                            U.agregarUsuario(usuarios);
                            h.imprimeMensaje("Usuario Agregado con Exito.");
                        } else {
                            h.imprimeMensaje("La lista de Usuarios se encuentra llena.");
                        }

                    } else {
                        h.imprimeMensaje("Debe generar primero la lista de Usuarios.");
                    }
                    break;

                case 'C':
                    if (poscUsuario == 0) {
                        h.imprimeMensaje("Debe agregar un cliente primero!");
                    } else {
                        U.modificarUsuario(usuarios, poscUsuario);
                    }
                    break;

                case 'D':
                    if (poscUsuario == 0) {
                        h.imprimeMensaje("Debe agregar un cliente primero!");
                    } else {
                        poscUsuario = U.eliminarUsuario(usuarios, poscUsuario);
                    }

                    break;
                case 'E':

                    break;

                case 'F':

                    break;
                case 'G':

                    break;
                case 'S':

                    break;
            }

        } while (opcion != 'S');
    }
}
