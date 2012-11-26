package main.variables;

import main.Meta;
import main.Session;
import main.Variable;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 2:21
 */
public class UserId implements Variable {
    @Override
    public List<Double> make(Session session) {
        return Arrays.asList((double) ((Meta) session.getRecords().get(0)).getUserId());
    }
}
