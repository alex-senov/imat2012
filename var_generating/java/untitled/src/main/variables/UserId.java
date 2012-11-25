package main.variables;

import main.Meta;
import main.Session;
import main.Variable;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 2:21
 */
public class UserId implements Variable {
    @Override
    public double make(Session session) {
        return ((Meta)session.getRecords().get(0)).getUserId();
    }
}
