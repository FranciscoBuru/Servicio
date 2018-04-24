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
    boolean indicadorTiempo = false;
    long start;
    long end;
    
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
     * Constructor que recibe un sudoku ya construido, matríz de 9x9.
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
     * columna de la matríz. Regresa ture si el número no esta en la columna.
     * Recibe la columna(col) y el número (num) a verificar.
     * @param col
     * @param num
     * @return boolean
     */
    
    private boolean resCol(int col, int num){
        boolean res = true;
        int i = 0;
        while(i<9 && res){
            if(sudoku[i][col] == num)
                res = false;
            else
                i++;
        }
        return res;
    }
    
    /**
     * Método booleano que verifica si un numero se encuentra, o no, en una fila
     * de la matríz.Regresa true si el número no está en la fila. 
     * Recibe la fila(fil) y el número (num) a veríficar
     * @param fil
     * @param num
     * @return boolean 
     */
    
    private boolean resFila(int fil, int num){
        boolean res = true;
        int i = 0;
        while(i<9 && res){
            if(sudoku[fil][i] == num)
                res = false;
            else
                i++;
        }
        return res;
    }
    
    /**
     * Método booleano que verifica si un numero se encuentra, o no, en un 
     * cuadro de 3x3 dentro de la matríz. Recibe la fila y la columna de
     * el primer elemento. Regresa true si el número no está en el cuadro. 
     * del caudro.
     * @param fila
     * @param col
     * @param num
     * @return Boolean
     */
    
    private  boolean cuadro(int fila, int col, int num){
        boolean res = true;
        int i = fila;
        int k = col;
        while(i<fila+3 && res){
            while(k<col+3 && res){
                if(sudoku[i][k] == num)
                    res = false;
                else
                    k++;
            }
            k=col;
            i++;
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
     * Método booleano para resolver el sudoku. El método se encarga
     * inicializar el contador de tiempo que se le otorga al método resuelve()
     * para intentar resolver el sudoku.
     * Regresa true si el sudoku tiene solución y false si: 1.- El sudoku no 
     * tiene solución o 2.- El método sobrepasa tiempo máximo de solución.  
     * 
     * @return boolean  
     */
    
    public boolean resuelv(){
        start = System.currentTimeMillis(); //Toma el tiempo actual del sistema
        end = start + 5*1000; // 5 seconds * 1000 ms/sec
        return resuelve();
    }
    
    /**
     * Método booleano recursivo que resuelve el sudoku de la clase.
     * Si después de 5 segundos en el método el programa no ha regresado un 
     * resultado el método se detendrá y regresa false. También indicara que el
     * tiempo máximo fue sobrepasado cambiando la variablr indicadorTiempo a 
     * true.
     * @return Boolean
     */
    
    private boolean resuelve(){
        for(int f =0; f<9 ; f++){
            for(int c = 0; c < 9 ; c++){
                if(sudoku[f][c] == 0){
                    for(int n =1; n<10 ; n++){
                        if(valida(f,c,n)){
                            sudoku[f][c] = n;
                            if(System.currentTimeMillis()>end){
                                indicadorTiempo = true;
                                return false;
                            }
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
     * Getter de la variable indicadorTiempo.
     * @return Boolean 
     */
    
    public boolean isIndicadorTiempo() {
        return indicadorTiempo;
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
            int f=0;
            int c =0;
            while(f<9 && res){
                while(c<9 && res){
                    if(sudoku[f][c] != 0){
                        aux = sudoku[f][c];
                        sudoku[f][c] = 0;
                        if(!valida(f,c,aux))
                            res = false;
                        else
                          sudoku[f][c] = aux;
                        
                    }
                    c++;
                }
                c=0;
                f++;
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
        int f=0;
        int c=0;
        while(f<9 && res){
            while(c<9 && res){
                if(!conj.contains(sudoku[f][c])){
                    res = false;
                }
                c++;
            }
            c=0;
            f++;
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

    
    
   
