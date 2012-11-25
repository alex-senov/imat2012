package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:53
 */
public class Click extends Record implements TimedRecord{
    private final int sessionId;
    private final int timePassed;
    private final int serpId;
    private final int urlId;

    public Click(String[] line) {
        this.sessionId = Integer.parseInt(line[0]);
        this.timePassed = Integer.parseInt(line[1]);
        this.serpId = Integer.parseInt(line[3]);
        this.urlId = Integer.parseInt(line[4]);
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

    public int getUrlId() {
        return urlId;
    }
}
