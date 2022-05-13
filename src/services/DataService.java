package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataService {
    private String fileName = "data.txt";

    public DataService() {
    }

    public void readFromFile() {
        // TODO - implement DataService.readFromFile
        throw new UnsupportedOperationException();
    }

    public void writeToFile() {
        // TODO - implement DataService.writeToFile
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write("Hello World");
            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to write to file");
            e.printStackTrace();
        }
    }

    public void editFile() {
        // TODO - implement DataService.editFile
        throw new UnsupportedOperationException();
    }
}
