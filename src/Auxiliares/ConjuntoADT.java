/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;



import java.util.Iterator;

/**
 *Interfáz de tipo ConjuntoADT<T>. Usa Iterable<T>.
 * @author Francisco Aramburu
 * @param <T>
 */
public interface ConjuntoADT <T> extends Iterable<T>{
    boolean contains(T dato);
    boolean isEmpty();
    boolean add(T dato);
    @Override
    Iterator<T> iterator();
   
    
}