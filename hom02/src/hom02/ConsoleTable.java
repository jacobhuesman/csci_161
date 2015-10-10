/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom02;

import java.util.Formatter;
import java.util.Locale;

/**
 * Creates a basic table that can be output to the console.
 * @author Jacob Huesman
 */

public class ConsoleTable {    
    //Static class
    private ConsoleTable(){}
    
    /**
     * Makes a table with a title.
     * @param title String that will be displayed as the title
     * @param width The preferred width of the table output. May be slightly modified to ensure columns are spaced evenly.
     * @param array Two dimensional String array that holds the data to be displayed in the table
     * @return A formatted string that when output to the console will be a table of data
     */
    public static String makeTable(String title, int width, String[] columnNames, String[][] array) {
        StringBuilder sb = new StringBuilder();
        Formatter format = new Formatter(sb, Locale.US);
        
        int columns = array[0].length;
        
        //Practical width
        int wid = ((width-1)/columns)*columns+1;
        
        //Create a centered title
        sb.append(addSeperator(wid));
        sb.append("|" + center(title, wid-2) + "|\n");
        sb.append(addSeperator(wid));
        
        String[][] col = new String[1][];
        col[0] = columnNames;
        
        //Add column names
        sb.append(genTable(width, col));
        
        //Create the rest of the table
        return sb.append(genTable(width, array)).toString();
    }
    
    /**
     * Makes a table with a title.
     * @param title String that will be displayed as the title
     * @param width The preferred width of the table output. May be slightly modified to ensure columns are spaced evenly.
     * @param array Two dimensional String array that holds the data to be displayed in the table
     * @return A formatted string that when output to the console will be a table of data
     */
    public static String makeTable(String title, int width, String[][] array){
        StringBuilder sb = new StringBuilder();
        int columns = array[0].length;
        
        //Practical width
        int wid = ((width-1)/columns)*columns+1;
        
        //Create a centered title
        sb.append(addSeperator(wid));
        sb.append("|" + center(title, wid-2) + "|\n");
        
        //Create the rest of the table
        return sb.append(makeTable(width, array)).toString();
    }
    
    private static String makeTable(int width, String[][] array){
        StringBuilder sbY = new StringBuilder();
        
        //Figure out rows and columns.
        int rows = array.length;
        int columns = array[0].length;
        
        //Practical width
        int wid = ((width-1)/columns)*columns+1;

        //Initial seperator
        sbY.append(addSeparator(wid, columns));
        
        return sbY.append(genTable(width, array)).toString();
        
    }
    
    /**
     * Generates a table to be used by the other methods of the class.
     * @param width The preferred width of the table output. May be slightly modified to ensure columns are spaced evenly.
     * @param array Two dimensional String array that holds the data to be displayed in the table
     * @return A formatted string that when output to the console will be a table of data
     */
    private static String genTable(int width, String[][] array){
        StringBuilder sbY = new StringBuilder();
        StringBuilder sbX;

        //Figure out rows and columns.
        int rows = array.length;
        int columns = array[0].length;
        
        //Practical width
        int wid = ((width-1)/columns)*columns+1;
        
        //Create rest of table
        try {
            for(int y=0; y<rows; y++){
                sbX = new StringBuilder();
                sbX.append("|");
                for(int x=0; x<columns; x++){
                    sbX.append(center(array[y][x], (width-1)/columns-1) + "|");
                }
                sbY.append(sbX.toString() + "\n");
                sbY.append(addSeparator(wid, columns));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException("There is at least one row in the array that does not have " + columns + " columns.");
        }
        return sbY.toString();
    }
    
    /**
     * Used to center a string, given a desired length of an output string.
     * @param text The text to be centered
     * @param len The length of the output string
     * @return A string of length len with text centered
     */
    private static String center( String text, int len ) {
        String out = String.format("%"+len+"s%s%"+len+"s", "", text, "");
        float mid = (out.length()/2);
        float start = mid - (len/2);
        float end = start + len;
        return out.substring((int)start, (int)end);
    }
    
    /**
     * Creates a separator to separate the rows of the table, taking into account the columns of the table.
     * @param width Width of the separator
     * @param columns Columns to be represented
     * @return String to be used as a separator
     */
    private static char[] addSeparator(int width, int columns){
        char[] sep = addSeperator(width);
        for(int i=1; i<columns; i++){
            sep[i*(width-1)/columns] = '+';
        }
        return sep;
    }
    
    /**
     * Creates a separator to separate the rows of the table.
     * @param width Width of the separator
     * @return String to be used as a separator
     */
    private static char[] addSeperator(int width){
        char[] sep = new char[width+1];
        sep[0] = '+';
        sep[width-1] = '+';
        sep[width] = '\n';
        for(int i=1; i<width-1; i++){
            sep[i] = '-';
        }
        return sep;
    }
}
