/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hom01;

import java.io.File;

/**
 * Simple class designed to hold the path to a file for storage across multiple threads.
 * @author Jacob Huesman
 */
public class FilePath {
    private String filePath;
    private boolean isFilePath;
    
    /**
     * Default Constructor
     */
    public FilePath(){
        filePath = "";
        isFilePath = false;
    }
    
    /**
     * Sets the file path and checks to make sure that the path specified points to a file.
     * @param filePath String that contains the file path to be set.
     */
    public void setFilePath(String filePath){
        this.filePath = filePath;
        isFilePath = new File(filePath).isFile();
    }
    
    /**
     * Returns the file path.
     * @return String representing the file path.
     */
    public String getFilePath(){
        return filePath;
    }
    
    /**
     * Returns if the current file path is valid.
     * @return true - if file path is valid; false - otherwise
     */
    public boolean getIsFilePath(){
        return isFilePath;
    }
}
