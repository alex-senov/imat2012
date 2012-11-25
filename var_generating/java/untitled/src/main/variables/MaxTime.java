package main.variables;

import main.Record;
import main.Session;
import main.TimedRecord;
import main.Variable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 2:13
 */
public class MaxTime implements Variable {

    @Override
    public double make(Session session) {
        int maxTime = ((TimedRecord)session.getRecords().get(1)).getTimePassed();
        int lastTime = maxTime;
        for (int i = 2; i < session.getRecords().size(); ++i) {
            Record record = session.getRecords().get(i);
            if (record instanceof TimedRecord) {
                int time = ((TimedRecord) record).getTimePassed();
                if (maxTime < time - lastTime) {
                    maxTime = time - lastTime;
                }
                lastTime = time;
            }
        }
        return maxTime;
    }
}
