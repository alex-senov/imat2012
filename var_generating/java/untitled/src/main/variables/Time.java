package main.variables;

import main.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:36
 */
public class Time implements Variable {
    @Override
    public List<Double> make(Session session) {
        Double totalTime = null;
        int maxTime = ((TimedRecord)session.getRecords().get(1)).getTimePassed();
        int lastTime = maxTime;
        for (int i = session.getRecords().size() - 1; i >= 0; --i) {
            Record record = session.getRecords().get(i);
            if (record instanceof TimedRecord) {
                int time = ((TimedRecord) record).getTimePassed();
                if (maxTime < time - lastTime) {
                    maxTime = time - lastTime;
                }
                lastTime = time;
                if (totalTime == null) {
                    totalTime = (double) time;
                }

            }
        }
        return Arrays.asList(totalTime, (double) maxTime);
    }
}
