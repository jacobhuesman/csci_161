/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GFile;

import java.io.File;
import java.util.ArrayList;

/**
 * Simple class designed to hold the paths to files for storage across multiple threads.
 * @author Jacob Huesman
 */
public class FilePath {
    private ArrayList<String> filePath;
    private boolean hasPath;
    
    /**
     * Default constructor.
     */
    public FilePath(){
        filePath = new ArrayList(1);
        hasPath = false;
    }
    
    /**
     * Adds a file path to the FilePath object. Before adding it checks to ensure the file path is valid.
     * @param filePath String representation of the file path
     * @return true if the file path passed as a parameter was valid and added; false - otherwise
     */
    public boolean addPath(String filePath){
        if(new File(filePath).isFile()){
            this.filePath.add(filePath);
            hasPath = true;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns a string array of file paths.
     * @return String[] representing the file paths.
     */
    public String[] getPaths(){
        String[] str = new String[filePath.size()];
        str = filePath.toArray(str);
        return str;
    }
    
    /**
     * Indicates if the object contains at least one file path.
     * @return true - if there is at least one file path contained in this object; false - otherwise
     */
    public boolean hasPath() {
        return hasPath;
    }
}
