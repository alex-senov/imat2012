package main.variables;

import main.Meta;
import main.Session;
import main.Variable;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 2:22
 */
public class Switch implements Variable {
    @Override
    public double make(Session session) {
        if (!((Meta)session.getRecords().get(0)).getSwitchType().equals(Meta.SwitchType.N)) {
            return 0;
        }
        return 1;
    }
}
