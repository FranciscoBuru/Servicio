/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author FARAMBURA
 */
public class Sudoku {

    
    
    int sudoku[][];

   
    public Sudoku() {
        
        sudoku= new int [9][9];
        
    }
    
    public Sudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    
    }
    
    private boolean resCol(int col, int num){
        
        boolean res = true;
        
        for(int i = 0; i<9; i++){
            
            if(sudoku[i][col] == num){
                res = false;
                
            }
        }
        return res;
        
    
    }
     
    private boolean resFila(int fil, int num){
        
        boolean res = true;
        
        for(int i = 0; i<9; i++){
            
            if(sudoku[fil][i] == num){
                res = false;
                
            }
        }
        return res;
        
    
    }
     
    private  boolean cuadro(int fila, int col, int num){
        
        boolean res = true;
        
        for(int i = fila; i<fila+3; i++){
            for(int k = col; k < col+3; k++){
                if(sudoku[i][k] == num){
                    res = false;
                }
            }
        }
        return res;
        
    
    }
    
    public boolean valida(int fila, int columna, int num){
    
        boolean res = false;
        
        int col, fil;
        
        
        if(columna<3){
            col = 0;
        }
        else if(columna<6){
            col = 3;
        }
        else{
            col = 6;
        }
        
        
        if(fila<3){
            fil = 0;
        }
        else if(fila<6){
            fil = 3;
        }
        else{
            fil = 6;
        }
        
        if(resCol(columna , num) && resFila(fila, num) && cuadro(fil, col, num)){
            res = true;
        }
        
        return res;
    
    
    
    }
    
    public boolean resuelve(){
        
        for(int f =0; f<9 ; f++){
            for(int c = 0; c < 9 ; c++){
                if(sudoku[f][c] == 0){
                    for(int n =1; n<10 ; n++){
                        if(valida(f,c,n)){
                            sudoku[f][c] = n;
                            if(resuelve()){
                                return true;
                            }
                            else{
                                sudoku[f][c] = 0;
                            }
                        
                        }
                    
                    
                    }
                return false;
                
                
                }
        
        
            }
        }
        return true;
        
        
        
        
    }
    
    
    
     public  void imprimeSudoku(){
        
        String res = "";
        
        for(int i =0; i<9; i++){
            for(int k = 0; k<9 ; k++){
                
                if(k==3 || k == 6 ){
                    res = res + " " + "|" + " ";
                }
                
                
                res = res + " " + sudoku[i][k];
                
            }
           
            if(i==2 || i==5){
                    res = res + "\n " + "------------------------" + "\n";
            }
            else
                 res = res + "\n";
        }
        System.out.println(res);
        
        
    }
     
    public int[][] regresaSudoku(){
        
        return sudoku;
    } 
 
}

    
    
   
