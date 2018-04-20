/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase pública que crea un ioterador
 * @author FARAMBURA
 */

public class IteradorArreglo<T> implements Iterator<T>{
    private T[] coleccion;
    private int elementosGuardados; 
    private int actual;
    
    public IteradorArreglo(T[] coleccion, int elementosGuardados){
        this.coleccion = coleccion;
        this.elementosGuardados = elementosGuardados;
        actual = 0; 
    }
    
    public boolean hasNext(){
        return actual < elementosGuardados;
    }
    
    
    public T next(){
        if(hasNext()){
           actual++; 
           return coleccion[actual - 1];
        }
        throw new NoSuchElementException();   
    }
    
   
    public void remove(){
        throw new UnsupportedOperationException();
    }
    
}
