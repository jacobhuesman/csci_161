/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

/**
 * Exception to handle bad data types being passed as a parameter.
 * @author Jacob Huesman
 */
public class IllegalDataTypeException extends IllegalArgumentException {
    /**
     * Exception to be thrown
     * @param message String containing details regarding the exception.
     */
    public IllegalDataTypeException ( String message ){
        super(message);
    }
}
