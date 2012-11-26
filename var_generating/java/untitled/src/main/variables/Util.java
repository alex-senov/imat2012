package main.variables;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Alexander Senov
 * Date: 25.11.12
 * Time: 23:02
 */
public class Util {
    public static double avg(Collection<Double> numbers) {
        if (numbers.size() == 0) return 0.;
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.size();
    }

    public static double max (Collection<Double> numbers) {
        if (numbers.size() == 0) return 0.;
        double max = numbers.iterator().next();
        for (double n : numbers) {
            if (max < n) max = n;
        }
        return max;
    }
}
