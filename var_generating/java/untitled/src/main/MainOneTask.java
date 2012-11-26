package main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:15
 */
public class MainOneTask {

    public static void main(String[] args) throws Exception {
        String inFilePath = args[0];
        int sessionsToRead = Integer.parseInt(args[1]);
        String outFilePath = args[2];
        String outSessions = args[3];

        Reader reader = new Reader(inFilePath);
        Writer writer = new Writer(outFilePath);
        Writer writer1 = new Writer(outSessions);
        String[] line = reader.read();
        String sessionId = line[0];
        int countSessions = 0;
        while (countSessions < sessionsToRead) {
            writer1.write(sessionId);
            List<Record> records = new LinkedList<Record>();
            while (sessionId.equals(line[0])) {
                records.add(Record.createRecord(line));
                line = reader.read();
                if (line == null) {
                    break;
                }
            }
            if (line!=null) sessionId = line[0];
            Session session = new Session(records);
            List<Double> vars = VariablesMaker.makeVariables(session);
            writer.write(vars);
            ++countSessions;

            if (line == null) {
                break;
            }
        }
        writer1.close();
        writer.close();
        reader.close();
    }





}
