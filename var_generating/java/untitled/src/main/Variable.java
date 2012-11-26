package main;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:21
 */
public interface Variable {
    List<Double> make(Session session);
}
