package main.variables;

import main.Record;
import main.Session;
import main.TimedRecord;
import main.Variable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 25.11.12
 * Time: 22:10
 */
public class Evolution implements Variable {
    @Override
    public List<Double> make(Session session) {
        Double totalTime = null;
        //first run to fing total time;
        for (int i = session.getRecords().size() - 1; i >= 0; --i) {
            Record record = session.getRecords().get(i);
            if (record instanceof TimedRecord) {
                int time = ((TimedRecord) record).getTimePassed();
                totalTime = (double) time;
                break;
            }
        }
        
        //second run to measure evolution
        double lastQuart = totalTime * 3 / 4;
        double countQueries = 0, countClicks = 0;
        for (int i = session.getRecords().size() - 1; i >= 0; --i) {
            Record record = session.getRecords().get(i);
            if (record instanceof TimedRecord) {
                int time = ((TimedRecord) record).getTimePassed();
                if (time < lastQuart) break;
                countQueries++;
                countClicks++;
            }
        }
        return Arrays.asList(countQueries, countClicks);
    }
}
