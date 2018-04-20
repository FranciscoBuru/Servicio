/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import Auxiliares.ConjuntoA;

/**
 * Clase con los métodos necesarios para verificar la validéz y resolver
 * un sudoku. 
 * @author Francisco Aramburu
 */
public class Sudoku {
    
    int sudoku[][];
    ConjuntoA<Integer> conj;
    /**
     * Constructor por omisión.
     */
    public Sudoku() {
        sudoku= new int [9][9];
        conj = new ConjuntoA();
        conj.add(0);
        conj.add(1);
        conj.add(2);
        conj.add(3);
        conj.add(4);
        conj.add(5);
        conj.add(6);
        conj.add(7);
        conj.add(8);
        conj.add(9);
    }
    /**
     * Constructor que recibe un sudoku ya contruido, matríz de 9x9.
     * @param sudoku 
     */
    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
        conj = new ConjuntoA();
        conj.add(0);
        conj.add(1);
        conj.add(2);
        conj.add(3);
        conj.add(4);
        conj.add(5);
        conj.add(6);
        conj.add(7);
        conj.add(8);
        conj.add(9);
    }
    /**
     * Método booleano que revisa si un número se encuentra, o no, en una 
     * columna de la matríz.Regresa ture si el número no esta en la columna.
     * Recive la columna(col) y el número (num) a verificar.
     * @param col
     * @param num
     * @return boolean
     */
    private boolean resCol(int col, int num){
        boolean res = true;
        for(int i = 0; i<9; i++){
            if(sudoku[i][col] == num){
                res = false;
            }
        }
        return res;
    }
    /**
     * Método booleano que verifica si un numero se encuentra, o no, en una fila
     * de la matríz.Regresa true si el número no está en la fila. 
     * Recive la fila(fil) y el número (num) a veríficar
     * @param fil
     * @param num
     * @return boolean 
     */
    private boolean resFila(int fil, int num){
        boolean res = true;
        for(int i = 0; i<9; i++){
            if(sudoku[fil][i] == num)
                res = false;
        }
        return res;
    }
    /**
     * Método booleano que verifica si un numero se encuentra, o no, en un 
     * cuadro de 3x3 dentro de la matríz. Recive la fila y la columna de
     * el primer elemento. Regresa true si el número no está en el cuadro. 
     * del caudro.
     * @param fila
     * @param col
     * @param num
     * @return Boolean
     */
    private  boolean cuadro(int fila, int col, int num){
        boolean res = true;
        for(int i = fila; i<fila+3; i++){
            for(int k = col; k < col+3; k++){
                if(sudoku[i][k] == num)
                    res = false;
            }
        }
        return res;
    }
    /**
     * Método booleano que valida, usando los métodos rescol(int,int), 
     * resfil(int,int) y cuadro(int,int,int), si un número se puede colocar 
     * en la posición [fila][columna] en la matríz. Regresa true si el número 
     * se puede colocar a la posición.
     * @param fila
     * @param columna
     * @param num
     * @return Boolean 
     */
    public boolean valida(int fila, int columna, int num){
        boolean res = false;
        int col, fil;
        if(columna<3)
            col = 0;
        else if(columna<6)
            col = 3;
        else
            col = 6;
        if(fila<3)
            fil = 0;
        else if(fila<6)
            fil = 3;
        else
            fil = 6;
        if(resCol(columna , num) && resFila(fila, num) && cuadro(fil, col, num))
            res = true;
        return res;
    }
    /**
     * Método booleano recursivo que resuelve el sudoku de la clase.
     * @return Boolean
     */
    public boolean resuelve(){
        for(int f =0; f<9 ; f++){
            for(int c = 0; c < 9 ; c++){
                if(sudoku[f][c] == 0){
                    for(int n =1; n<10 ; n++){
                        if(valida(f,c,n)){
                            sudoku[f][c] = n;
                            if(resuelve())
                                return true;
                            else
                                sudoku[f][c] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Método Booleano que revisa si la matríz que representa al sudoku en la 
     * clase es, en si, un sudoku válido. Regresa true si es un sudoku.
     * (Un sudoku no tiene números repetidos ni menores a 0 y mayores a 9 en 
     * sus filas columnas y cuadros).
     * @return Boolean
     */
    public boolean revisionInicial(){
        boolean res = true;
        int aux;
        if(revisionNumerosValidos()){
            for(int f = 0; f<9; f++){
                for(int c = 0; c<9 ; c++){
                    if(sudoku[f][c] != 0){
                        aux = sudoku[f][c];
                        sudoku[f][c] = 0;
                        if(!valida(f,c,aux))
                            res = false;
                        else
                          sudoku[f][c] = aux;
                    }
                }
            }
        }
        else
            res=false;
        return res;
    }
    /**
     * Método boolean que revisa si todos los números dentro de la matríz que 
     * representa al sudoku son números válidos. (Entre 0 y 9). Regresa true si
     * todos los números son validos.
     * @return Boolean
     */
    public boolean revisionNumerosValidos(){
        boolean res = true;
        for(int f = 0; f<9; f++){
            for(int c = 0; c<9 ; c++){
                if(!conj.contains(sudoku[f][c])&& res){
                    res = false;
                }
            }
        }
        return res;
    }
    /**
     * Método que imprime el sudoku en el main(psvm).
     */
    public  void imprimeSudoku(){
        String res = "";
        for(int i =0; i<9; i++){
            for(int k = 0; k<9 ; k++){
                if(k==3 || k == 6 )
                    res = res + " " + "|" + " ";
                res = res + " " + sudoku[i][k];
            }
            if(i==2 || i==5)
                    res = res + "\n " + "------------------------" + "\n";
            else
                 res = res + "\n";
        }
        System.out.println(res);
    }
    /**
     * Método que regresa el sudoku de la clase.
     * @return sudoku[][].
     */
    public int[][] regresaSudoku(){
        return sudoku;
    } 
 
}

    
    
   
