package main;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:05
 */
public class Meta extends Record{

    public enum SwitchType {
        B,
        P,
        H,
        N,
    }

    private final int sessionId;
    private final int day;
    private final int userId;
    private final SwitchType switchType;

    public Meta(String[] line) {
        this.sessionId = Integer.parseInt(line[0]);
        this.day = Integer.parseInt(line[1]);
        this.userId = Integer.parseInt(line[3]);
        if (line.length > 4) {
            this.switchType = SwitchType.valueOf(line[4]);
        }
        else {
            switchType = SwitchType.N;
        }
    }


    public int getSessionId() {
        return sessionId;
    }

    public int getDay() {
        return day;
    }

    public int getUserId() {
        return userId;
    }

    public SwitchType getSwitchType() {
        return switchType;
    }
}
