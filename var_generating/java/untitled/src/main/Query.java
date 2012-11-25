package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:12
 */
public class Query extends Record implements TimedRecord{
    private final int sessionId;
    private final int timePassed;
    private final int serpId;
    private final int queryId;
    private final int[] listOfURLs;

    public Query(String[] line) {
        this.sessionId = Integer.parseInt(line[0]);
        this.timePassed = Integer.parseInt(line[1]);
        this.serpId = Integer.parseInt(line[4]);
        this.queryId = Integer.parseInt(line[5]);
        int offset = 5;
        this.listOfURLs = new int[line.length - offset];
        for (int i = offset; i < line.length; ++i) {
            this.listOfURLs[i - offset] = Integer.parseInt(line[i]);
        }
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getTimePassed() {
        return timePassed;
    }

    public int getSerpId() {
        return serpId;
    }

    public int getQueryId() {
        return queryId;
    }

    public int[] getListOfURLs() {
        return listOfURLs;
    }
}
