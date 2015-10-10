/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

import java.util.ArrayList;

/**
 * Static class that takes an ArrayList of TokenCheck objects and sorts it.
 * @author Jacob Huesman
 */
public class SortTokenCheck {

     //Static class doesn't need a constructor.
    private SortTokenCheck(){}
    
    /**
     * Sorts an ArrayList of TokenCheck objects alphabetically by the token type and further sorts them by the String.
     * @param array ArrayList of TokenCheck objects to be sorted.
     */
    public static void sort(ArrayList<TokenCheck> array){        
        //No point in sorting an array of one object or less.
        if(!(array.size()>1)){
            return;
        }
        
        //Insertion Sort Token Type aphabetically.
        for(int i=1; i<array.size(); i++){
            TokenCheck cur = array.get(i);
            for(int a=i-1; a>=0; a--){
                if(cur.getType().compareTo(array.get(a).getType()) < 0){
                    array.set(a+1, array.get(a));
                    array.set(a, cur);
                } else {
                    break;
                }
            }
        }
        
        //Insertion Sort String alphabetically while retaining order of token type.
        for(int i=1; i<array.size(); i++){
            TokenCheck cur = array.get(i);
            for(int a=i-1; a>=0; a--){
                if(cur.getType().compareTo(array.get(a).getType()) == 0){
                    if(cur.getData().compareTo(array.get(a).getData()) < 0){
                        array.set(a+1, array.get(a));
                        array.set(a, cur);
                    }  
                } else {
                    break;
                }
            }
        }
    }
    
}
