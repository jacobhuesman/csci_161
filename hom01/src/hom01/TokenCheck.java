/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

import java.io.Serializable;
import java.util.Scanner;
/**
 * Takes a String made of tokens and determines their datatype.
 * @author Jacob Huesman
 */
public class TokenCheck implements Serializable {
    
    /**
     * Declare instance variables.
     */
    private String data;
    private String delimiter;
    private String type;
    
    /**
     * Default constructor creates an object with an empty String, no specified delimiter, and unknown for the token type.
     */
    public TokenCheck(){
        data = new String();
        delimiter = new String();
        type = "unknown";
    }
    
    /**
     * Overloaded constructor that creates an object with the String and delimiter set to the parameter values and token type set to its appropriate value.
     * @param data String to be checked for tokens.
     * @param delimiter The delimiter used to separate the token from the String.
     */
    public TokenCheck(String data, String delimiter) {
        this.data = data;
        this.delimiter = delimiter;
        determineTokenType();
    }
    
    /**
     * Determines the token type for the String.
     */
    private void determineTokenType(){
        if(checkTokens("int")){
            type = "int";
        } else if (checkTokens("double")){
            type = "double";
        } else if (checkTokens("boolean")){
            type = "boolean";
        } else if (checkTokens("char")){
            type = "char";
        } else {
            type = "mixed";
        }
    }
    
    /**
     * Checks Tokens to see if they belong to a specified datatype.
     * @param dataType Datatype to check for.
     * @return true - if the tokens belong to that datatype; false - otherwise
     * @throws IllegalDataTypeException Throws if the method can't check for that datatype.
     */
    private boolean checkTokens(String dataType) throws IllegalDataTypeException {
        //Initiate Scanner object and set it to use the specified delimiter. Also removes all whitespace to make scanning data accidental whitespace more accurate.
        String operatingData = data.replaceAll(" ", "");
        Scanner scan = new Scanner(operatingData);
        scan.useDelimiter(delimiter.trim());
        
        //Check what datatype the method is looking for.
        switch (dataType.toLowerCase()){
            case "int": 
                while(scan.hasNextInt()){
                    scan.nextInt();
                }
                if(scan.hasNext()){
                    return false;
                }
                return true;
            case "double":
                while(scan.hasNextDouble()){
                    scan.nextDouble();
                }
                if(scan.hasNext()){
                    return false;
                }
            return true;
            case "boolean":
            case "bool":
                while(scan.hasNextBoolean()){
                    scan.nextBoolean();
                }
                if(scan.hasNext()){
                    return false;
                }
            case "character":
            case "char":
                while(scan.hasNext()){
                    if(scan.next().trim().length() != 1){
                        return false;
                    };
                }
                return true;
        }  
        //If the datatype specified isn't handled by this method throw an IllegalDataTypeException.
        throw new IllegalDataTypeException( "Datatype not supported." );            
    }
    
    /**
     * Sets the data and delimiter. Also recalculates the token type and stores the result.
     * @param data String to be checked for tokens.
     * @param delimiter Delimiter to separate Strings by.
     */
    public void setDataAndDelimiter( String data, String delimiter ){
        this.data = data;
        this.delimiter = delimiter;
        determineTokenType();
    }
    
    /**
     * Gets the String of data.
     * @return data : String
     */
    public String getData(){
        return data;
    }
    
    /**
     * Returns the delimiter set for this TokenCheck object.
     * @return delimiter : char
     */
    public String getDelimiter(){
        return delimiter;
    }
    
    /**
     * Returns the type of data passed to the constructor.
     * @return type : String
     */
    public String getType(){
        return type;
    }
    
    /**
     * Returns a String representation of the data and delimiter.
     * @return String
     */
    public String toString(){
        return String.format("| %1$-60s | %2$-15s | %3$-20s\n", "Data: " + data, "Delimiter: " + delimiter, "Type: " + type);
    }
    
    /**
     * Checks to see if this TokenCheck object equals another TokenCheck object.
     * @param token TokenCheck object to check against.
     * @return true - if they are equal; false - otherwise
     */
    public boolean equals(TokenCheck token){
        if(this.data.equals(token.getData()) && this.delimiter.equals(token.getDelimiter()) && this.type.equals(token.getType())){
            return true;
        }
        return false;
    }
}
