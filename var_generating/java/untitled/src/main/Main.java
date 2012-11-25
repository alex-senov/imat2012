package main;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:15
 */
public class Main {
    public static final String DEFAULT_IN_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/dataset/test";
    public static final String DEFAULT_OUT_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/vars_test1.txt";
    public static final String DEFAULT_OUTPUT = "/media/2A306A0F3069E275/study/intmat2012/test_sessions.txt";
    public static final int DEFAULT_SESSIONS_TO_READ = 1000000;

    public static void main(String[] args) throws Exception {
        String inFilePath = (args.length < 1) ? DEFAULT_IN_FILE_PATH : args[0];
        int sessionsToRead = (args.length < 2) ? DEFAULT_SESSIONS_TO_READ : Integer.parseInt(args[1]);
        String outFilePath = (args.length < 3) ? DEFAULT_OUT_FILE_PATH : args[2];

        Reader reader = new Reader(inFilePath);
        Writer writer = new Writer(outFilePath);
        Writer writer1 = new Writer(DEFAULT_OUTPUT);
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
