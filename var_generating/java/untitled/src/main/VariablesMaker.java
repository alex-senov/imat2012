package main;

import main.variables.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:09
 */
public class VariablesMaker {
    
    public static List<Variable> variables = Arrays.asList(
            new main.variables.Switch(),
            new UserId(),
            new MaxTime(),
            new ClickCount(),
            new QueriesCount(),
            new TimeTotal()
    );
    
    public static List<Double> makeVariables(Session session) {
        List<Double> result = new ArrayList<>(variables.size());
        for (Variable v : variables) {
            result.add(v.make(session));
        }
        return result;
    }
}
