/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab09_jacob_huesman;

import java.util.Random;

/**
 * Value object designed to satisfy the requirements of lab09.
 * @author Jacob Huesman
 */
public class Value {
    private final int order, priority;
    private final Random random = new Random();
    
    /**
     * Constructor that allows for the specification of the order of the object.
     * @param order order of the object
     */
    public Value(int order){
        this.order = order;
        priority = random.nextInt(11);
    }
    
    /**
     * Returns the insertion order of this object
     * @return order
     */
    public int getOrder(){
        return order;
    }
    
    /**
     * Returns the priority of this object
     * @return priority
     */
    public int getPriority(){
        return priority;
    }
    
    public String toString(){
        return String.valueOf(order);
    }
}
