package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:58
 */
public class Switch extends Record implements TimedRecord{
    private final int sessionId;
    private final int timePassed;

    public Switch(String[] line) {
        this.sessionId = Integer.parseInt(line[0]);
        this.timePassed = Integer.parseInt(line[1]);
    }

    public int getSessionId() {
        return sessionId;
    }

    public int getTimePassed() {
        return timePassed;
    }
}
