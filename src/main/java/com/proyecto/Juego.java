
package com.proyecto;


public class Juego {
 
     private int sudoku [][];
     
     public Juego(){
         int tablero[][]={
             {5,0,0,0,0,0,0,0,4},
             {0,0,0,0,2,0,0,0,0},
             {0,0,0,0,0,0,0,0,0},
             {0,5,0,0,0,0,0,0,0},
             {0,0,0,0,0,4,0,0,5},
             {0,0,0,0,0,0,0,0,0},
             {3,0,9,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,0},
             {0,0,0,0,0,0,0,0,9},
             
         };
      sudoku=tablero;
     }
     public boolean resolverSudoku() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) { //Se recorre toda fila y la columba 
                if (sudoku[i][j] == 0){ // Se valida que los valores de la fila y la columna sean cero 
                    for (int valor = 1; valor <= 9; valor++) {
                        if (validarFila(i, valor) && validarColumna(j, valor) && validarCuadrante(i, j, valor)) {
                            sudoku[i][j] = valor;
                            if (resolverSudoku()) {
                                return true;
                            }
                            sudoku[i][j] = 0; //Backtraking = se valida despues de no poder resolver la primera vez , regresa y da el resultado  correcto, tambien es el truco para las trampas
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean validarCuadrante(int i, int j, int valor) { 
        int posicionI = subCuadranteActual(i);
        int posicionJ = subCuadranteActual(j);

        for (int k = posicionI - 3; k < posicionI; k++) {
            for (int l = posicionJ - 3; l < posicionJ; l++) {
                if (sudoku[k][l] == valor) {
                    return false;
                }
            }
        }
        return true;
    }

    public int subCuadranteActual(int pos) { // validamos en cual 3x3 estamos,  2  6 , 9 . 
        if (pos <= 2) {
            return 3;
        } else if (pos <= 5) {
            return 6;
        } else {
            return 9;
        }
    }

    public boolean validarFila(int i, int valor) {
        for (int j = 0; j < sudoku[i].length; j++) {
            if (sudoku[i][j] == valor) {
                return false;
            }
        }
        return true;
    }

    public boolean validarColumna(int j, int valor) {
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][j] == valor) {
                return false;
            }
        }
        return true;
    }
     
     public void mostrarSudoku() {
        resolverSudoku();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[0].length; j++) {
                System.out.print(sudoku[i][j]);
                if (!(j == sudoku[0].length - 1)) {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
    public int[][] getSudoku() {
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }
     
     
     
}
