import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Histogram<T> {

    private final List<T> data;

    public Histogram(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public Map<T, Integer> getHistogram() {
        Map<T, Integer> histogram = new HashMap<>();
        for (T key : data) {
            histogram.put(key, histogram.containsKey(key) ? histogram.get(key) + 1 : 1);
        }
        return histogram;
    };
}
