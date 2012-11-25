package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:46
 */
public class Writer {
    
    private final BufferedWriter writer;
    
    public Writer(String filePath) throws IOException{
        writer = new BufferedWriter(new FileWriter(filePath));
    }
    
    public void write(List<Double> values) throws IOException{
        String str = "";
        for (Double v : values) {
            str += v + " ";
        }
        str = str.substring(0, str.length() - 1) ;
        writer.write(str);
        writer.newLine();
    }
    
    public void write(String str) throws IOException {
        writer.write(str);
        writer.newLine();
    }

    public void close() throws IOException{
        writer.flush();
        writer.close();
    }
}
