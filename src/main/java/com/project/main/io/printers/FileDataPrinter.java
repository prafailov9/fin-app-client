package com.project.main.io.printers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prafailov
 */
public class FileDataPrinter implements DataPrinter {

    private final String destination;

    public FileDataPrinter(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean print(String data) {
        BufferedWriter writer = null;
        boolean success = false;
        try {
            String str = "Hello";
            writer = new BufferedWriter(new FileWriter(destination));
            writer.write(data);
            writer.close();
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(FileDataPrinter.class.getName()).log(Level.SEVERE, null, ex);
            success = false;
        } finally {
            return success;
        }
    }
    
    @Override
    public boolean printAll(List<String> contents) {
        boolean success = false;
        for (String content : contents) {
            success = print(content);
        }
        return success;
    }

}
