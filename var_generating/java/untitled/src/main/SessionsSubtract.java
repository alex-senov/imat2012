package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 11.11.12
 * Time: 20:50
 */
public class SessionsSubtract {
    public static final String DEFAULT_OUTPUT = "/media/2A306A0F3069E275/study/intmat2012/train_sessions.txt";
    public static void main(String[] args) throws Exception {
        String inFilePath = (args.length < 1) ? Main.TRAIN_DEFAULT_IN_FILE_PATH : args[0];
        String outFilePath = (args.length < 2) ? DEFAULT_OUTPUT : args[2];

        Reader reader = new Reader(inFilePath);
        Writer writer = new Writer(outFilePath);

        String[] line;
        while ((line = reader.read()) !=null) {
            writer.write(line[0]);
        }
        writer.close();
    }

}
