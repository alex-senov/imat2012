package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:24
 */
public abstract class Record {
    private static final int typePosition = 2;
    
    public abstract int getSessionId();

    public static Record createRecord(String[] line) {
        switch (line[typePosition]) {
            case "M" : return new Meta(line);
            case "Q" : return new Query(line);
            case "C" : return new Click(line);
            case "S" : return new Switch(line);
        }
        throw new IllegalArgumentException("Unknown record type : " + line[typePosition]);
    }
}
