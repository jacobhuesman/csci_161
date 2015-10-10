/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GFile;

/**
 * Class containing simple methods to graphically request files from a user. 
 * @author Jacob Huesman
 */
public class GFile {
    public static String[] getFiles() throws Exception{
        FilePath path = new FilePath();
      
        //Makes an empty thread that causes the the main client to wait until the thread finishes executing. The thread finishes executing when the user either selects a file or closes the window.
        Thread thread = new Thread(new Runnable(){public void run(){try {while(true){Thread.sleep(1000);}} catch (InterruptedException e){}}});
        thread.start();
        
         //Runs an instance of GetFile. GetFile is a GUI that prompts the user for a file to import data from.
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI(path, thread).setVisible(true);
            }
        });

        //The client will wait for the user to select a file before continuing.
        thread.join();
        //Checks if the user provided a file. Triggered if user exits the application without importing a file.
        if(!path.hasPath()){
            throw new Exception("User failed to provide a valid file.");
        } 
        
        //Return the file path
        return path.getPaths();  
    }
}
