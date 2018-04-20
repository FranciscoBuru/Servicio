/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.util.Iterator;

/**
 * Clase ConjuntoA con los métodos necesarios para ser implementada en la clase 
 * sudoku 
 * @author Francisco Aramburu
 * @param <T>
 */
public class ConjuntoA<T> implements ConjuntoADT<T>{
    private T[] conjunto;
    private int cardinalidad; 
    private final int MAXIMO = 50;
    /**
     * Constructor por omisión
     */
    public ConjuntoA(){
        conjunto = (T[])new Object[MAXIMO];
        cardinalidad = 0;
    }
    /**
     * Método booleano que regresa true si el conjunto está vacío. 
     * @return 
     */
    @Override
    public boolean isEmpty(){
        return cardinalidad == 0;
    }
    /**
     * Método que contruye un iterados de la clase Iterator y lo regresa.
     * @return 
     */
    @Override
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    /**
     * Método booleanp que recibe un parámetro de tipo T y verifica se este se
     * encuentra, o no, en el conjunto. Regresa true si el parámetro se 
     * encuentra en el conjunto.
     * @param obj
     * @return Boolan 
     */
    @Override
    public boolean contains(T obj){
        boolean contiene;
        Iterator<T> iterador;
        
        iterador = this.iterator();
        contiene = false;
        while(iterador.hasNext() && !contiene)
            contiene = iterador.next().equals(obj);
        return contiene;
    } 
    /**
     * Método que extiende el arreglo en el que se encuentra el conjunto.
     */
    private void extiendeArreglo(){
        T[] nuevoConjunto;
        int i, longitud;
        
        longitud = conjunto.length;
        nuevoConjunto =  (T[]) new Object[longitud * 20];
        for(i = 0; i < longitud; i++)
            nuevoConjunto[i] = conjunto[i];
        conjunto = nuevoConjunto;
    }
    /***
     * Método booleano que agrega un elemento al conjunto. Regresa true si el 
     * elemento se pudo agregar (Los elementos que ya estan en el conjunto no
     * se vuelven a agregar por definición de conjunto.)
     * @param obj
     * @return 
     */
    @Override
    public boolean add(T obj){
        boolean agrega;
        
        if(contains(obj))
            agrega =  false;
        else{
            if(conjunto.length == cardinalidad)
                extiendeArreglo();
            conjunto[cardinalidad] = obj;
            cardinalidad++;
            agrega = true;
        }
        return agrega;    
    }

}
