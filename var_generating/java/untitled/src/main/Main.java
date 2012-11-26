package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 25.11.12
 * Time: 23:31
 */
public class Main {

    public static final String TRAIN_DEFAULT_IN_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/dataset/train";
    public static final String TRAIN_DEFAULT_OUT_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/vars_train1.txt";
    public static final String TRAIN_DEFAULT_OUTPUT = "/media/2A306A0F3069E275/study/intmat2012/train_sessions.txt";
    public static final int TRAIN_DEFAULT_SESSIONS_TO_READ = 1000000;

    public static final String TEST_DEFAULT_IN_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/dataset/test";
    public static final String TEST_DEFAULT_OUT_FILE_PATH = "/media/2A306A0F3069E275/study/intmat2012/vars_test1.txt";
    public static final String TEST_DEFAULT_OUTPUT = "/media/2A306A0F3069E275/study/intmat2012/test_sessions.txt";
    public static final int TEST_DEFAULT_SESSIONS_TO_READ = 1000000;


    public static void main(String[] args) throws Exception {

        String trainInFilePath = (args.length < 1) ? TRAIN_DEFAULT_IN_FILE_PATH : args[0];
        int trainSessionsToRead = (args.length < 2) ? TRAIN_DEFAULT_SESSIONS_TO_READ : Integer.parseInt(args[1]);
        String trainOutFilePath = (args.length < 3) ? TRAIN_DEFAULT_OUT_FILE_PATH : args[2];
        String trainOutSessions = (args.length < 4) ? TRAIN_DEFAULT_OUTPUT : args[3];

        String testInFilePath = (args.length < 5) ? TEST_DEFAULT_IN_FILE_PATH : args[4];
        int testSessionsToRead = (args.length < 6) ? TEST_DEFAULT_SESSIONS_TO_READ : Integer.parseInt(args[5]);
        String testOutFilePath = (args.length < 7) ? TEST_DEFAULT_OUT_FILE_PATH : args[6];
        String testOutSessions = (args.length < 8) ? TEST_DEFAULT_OUTPUT : args[7];
        
        MainOneTask.main(new String[] {
                trainInFilePath,
                Integer.toString(trainSessionsToRead),
                trainOutFilePath,
                trainOutSessions
        });

        MainOneTask.main(new String[] {
                testInFilePath,
                Integer.toString(testSessionsToRead),
                testOutFilePath,
                testOutSessions
        });


    }
}
