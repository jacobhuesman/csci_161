/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

import java.util.Comparator;

/**
 * Comparator that is based off of the class of the same name presented in Data Structures & Algorithms by Goodrich, Tamassia, & Goldwasser
 * @author Jacob Huesman
 * @param <E>
 */
public class DefaultComparator<E> implements Comparator<E> {
    /**
     * Compares two elements
     * @param a first element
     * @param b second element
     * @return returns a negative integer if a is less than b, 0 if a is equal to be, or a positive integer if a is greater than b
     * @throws ClassCastException 
     */
    @Override
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
