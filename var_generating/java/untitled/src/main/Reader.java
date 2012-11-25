package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 09.11.12
 * Time: 23:58
 */
public class Reader {
    private final BufferedReader reader;
    
    public Reader(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }


    public String[] read() throws IOException{
        String line = reader.readLine();
        if (line == null) {
            return null;
        }
        return line.split("\t");
    }

    public void close() throws IOException {
        reader.close();
    }
    
}
