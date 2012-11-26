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
 * Time: 2:22
 */
public class Switch implements Variable {
    @Override
    public List<Double> make(Session session) {
        double result = 1.;
        if (!((Meta)session.getRecords().get(0)).getSwitchType().equals(Meta.SwitchType.N)) {
            result = 0;
        }
        return Arrays.asList(result);
    }
}
