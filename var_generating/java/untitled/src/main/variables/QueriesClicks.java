package main.variables;

import main.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 25.11.12
 * Time: 22:23
 */
public class QueriesClicks implements Variable {
    // vars for output;
    private int queriesNoClicks;
    private int queryAfterQuery;
    private int queries;
    private int clicks;

    // temp variables;
    private boolean wasQuery;
    private boolean wasClick;
    private int wasTime;
    private List<Double> queryClickLags;
    private List<Double> clickClickLags;
    private int clicksAfterQuery;
    private List<Double> clicksAfterQueryList;

    @Override
    public List<Double> make(Session session) {
        queriesNoClicks = 0;
        queryAfterQuery = 0;
        queries = clicks = 0;
        queryClickLags = new ArrayList<>();
        clickClickLags = new ArrayList<>();
        clicksAfterQueryList = new ArrayList<>();
        wasClick = wasQuery = false;
        

        for (Record record : session.getRecords()) {
            countQueriesNoClicks(record);
            countQueriesAfterQuery(record);
            queryClickLag(record);
            clickClickLag(record);
            clicksAfterQueryCount(record);

            wasQuery = record instanceof Query;
            wasClick = record instanceof Click;
            if (wasQuery) wasTime = ((Query) record).getTimePassed();
            if (record instanceof Click) ++ clicks;
            if (wasQuery) ++ queries;
        }



        return Arrays.asList(
                (double) queriesNoClicks / (double) queries,
                (double) queryAfterQuery / (double) queries,
                (double) queries,
                (double) clicks,
                Util.max(queryClickLags),
                Util.avg(queryClickLags),
                Util.max(clickClickLags),
                Util.avg(clickClickLags),
                Util.max(clicksAfterQueryList),
                Util.avg(clicksAfterQueryList)
                );
    }

    private void clicksAfterQueryCount(Record record) {
        if (clicksAfterQuery > 0) {
            if (record instanceof Click) {
                clicksAfterQuery++;
            }
            else {
                clicksAfterQueryList.add((double) clicksAfterQuery);
                clicksAfterQuery = 0;
            }
        }
        else {
            if (record instanceof Query) {
                clicksAfterQuery = 1;
            }
        }
    }
    
    private void clickClickLag(Record record) {
        if (wasClick && (record instanceof Click)) {
            int time = ((Click) record).getTimePassed();
            double lag = time - wasTime;
            clickClickLags.add(lag);
        }
    }

    private void queryClickLag(Record record) {
        if (wasQuery && (record instanceof Click)) {
            int time = ((Click) record).getTimePassed();
            double lag = time - wasTime;
            queryClickLags.add(lag);
        }
    }



    private void countQueriesAfterQuery(Record record) {
        if (record instanceof Query) {
            queryAfterQuery++;
        }
    }

    private void countQueriesNoClicks(Record record) {
        if (wasQuery && !(record instanceof Click)) {
            queriesNoClicks++;
        }
    }

}
