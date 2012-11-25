package main.variables;

import main.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:36
 */
public class TimeTotal implements Variable {
    @Override
    public double make(Session session) {
        for (int i = session.getRecords().size() - 1; i >= 0; --i) {
            Record record = session.getRecords().get(i);
            if (record instanceof TimedRecord) {
                return ((TimedRecord) record).getTimePassed();
            }
        }
        return 0;
    }
}
