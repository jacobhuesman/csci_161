/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom03;

/**
 * Convenient String Operations
 * @author Jacob Huesman
 */
public class StringOps {
    /**
     * Eliminates all punctuation and spacing from two strings before comparing the two ignoring the case.
     * @param str1 First string for comparison
     * @param str2 Second string for comparison
     * @return true - if the strings match in the absence of case and punctuation; false - otherwise
     */
    public static boolean equalsIgnoreCaseAndPunctuation(String str1, String str2){
        String str1mod, str2mod;

        //Get rid of spaces
        str1mod = str1.replaceAll(" ", "");
        str2mod = str2.replaceAll(" ", "");
        
        //Get rid of punctuation
        str1mod = str1mod.replaceAll("!", "");
        str2mod = str2mod.replaceAll("!", "");
        str1mod = str1mod.replaceAll("\\?", "");
        str2mod = str2mod.replaceAll("\\?", "");
        str1mod = str1mod.replaceAll(",", "");
        str2mod = str2mod.replaceAll(",", "");
        str1mod = str1mod.replaceAll("\\.", "");
        str2mod = str2mod.replaceAll("\\.", "");
        str1mod = str1mod.replaceAll(":", "");
        str2mod = str2mod.replaceAll(":", "");
        str1mod = str1mod.replaceAll(";", "");
        str2mod = str2mod.replaceAll(";", "");
        str1mod = str1mod.replaceAll("-", "");
        str2mod = str2mod.replaceAll("-", "");
        str1mod = str1mod.replaceAll("\\(", "");
        str2mod = str2mod.replaceAll("\\(", "");
        str1mod = str1mod.replaceAll("\\)", "");
        str2mod = str2mod.replaceAll("\\)", "");
        str1mod = str1mod.replaceAll("\\{", "");
        str2mod = str2mod.replaceAll("\\{", "");
        str1mod = str1mod.replaceAll("\\}", "");
        str2mod = str2mod.replaceAll("\\}", "");
        str1mod = str1mod.replaceAll("\\[", "");
        str2mod = str2mod.replaceAll("\\[", "");
        str1mod = str1mod.replaceAll("\\]", "");
        str2mod = str2mod.replaceAll("\\]", "");
        str1mod = str1mod.replaceAll("\\'", "");
        str2mod = str2mod.replaceAll("\\'", "");
        str1mod = str1mod.replaceAll("\"", "");
        str2mod = str2mod.replaceAll("\"", "");
        str1mod = str1mod.replaceAll("\\*", "");
        str2mod = str2mod.replaceAll("\\*", "");
        str1mod = str1mod.replaceAll("\\_", "");
        str2mod = str2mod.replaceAll("\\_", "");
        str1mod = str1mod.replaceAll("\\/", "");
        str2mod = str2mod.replaceAll("\\/", "");
        
        //Return the result of the comparison
        return str1mod.equalsIgnoreCase(str2mod);
    }
}
