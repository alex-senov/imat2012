package main.variables;

import main.*;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 1:26
 */
public class ClickCount implements Variable {
    @Override
    public double make(Session session) {
        int count = 0;
        for (Record record : session.getRecords()) {
            if (record instanceof Click) {
                ++count;
            }
        }     /home/obus/IdeaProjects/untitled/src/main/variables/ClickCount.java
        return count;
    }
}
