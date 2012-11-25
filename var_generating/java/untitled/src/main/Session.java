package main;

import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 10.11.12
 * Time: 0:22
 */
public class Session {
    private final List<Record> records;

    public Session(List<Record> records) {
        this.records = Collections.unmodifiableList(records);
    }

    public List<Record> getRecords() {
        return records;
    }
}
