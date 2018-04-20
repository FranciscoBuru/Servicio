/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.util.Iterator;

/**
 *
 * @author FARAMBURA
 * @param <T>
 */
public class ConjuntoA<T> implements ConjuntoADT<T>{
    private T[] conjunto;
    private int cardinalidad; 
    private final int MAXIMO = 50;
    
    public ConjuntoA(){
        conjunto = (T[])new Object[MAXIMO];
        cardinalidad = 0;
    }
    
    @Override
    public boolean isEmpty(){
        return cardinalidad == 0;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new IteradorArreglo(conjunto, cardinalidad);
    }
    
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
    
    private void extiendeArreglo(){
        T[] nuevoConjunto;
        int i, longitud;
        
        longitud = conjunto.length;
        nuevoConjunto =  (T[]) new Object[longitud * 20];
        for(i = 0; i < longitud; i++)
            nuevoConjunto[i] = conjunto[i];
        conjunto = nuevoConjunto;
    }
    
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
