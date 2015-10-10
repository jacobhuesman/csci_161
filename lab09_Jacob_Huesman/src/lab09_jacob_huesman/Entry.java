/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

/**
 * Entry Interface based off of the Entry Interface presented in Data Structures & Algorithms by Goodrich, Tamassia, & Goldwasser
 * @author Jacob Huesman
 * @param <K>
 * @param <V>
 */
public interface Entry<K,V> {
    /**
     * Returns the key stored in this entry object.
     * @return the entry's key
     */
    K getKey();
    
    /**
     * Returns the value stored in this entry object.
     * @return the entry's value
     */
    V getValue();
}
