package main.variables;


import main.Query;
import main.Record;
import main.Session;
import main.Variable;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:21
 */
public class QueriesCount implements Variable {
    @Override
    public double make(Session session) {
        int count = 0;
        for (Record record : session.getRecords()) {
            if (record instanceof Query) {
                ++count;
            }
        }
        return count;
    }
}

