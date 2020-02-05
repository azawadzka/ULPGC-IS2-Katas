import java.util.HashMap;
import java.util.Map;

public class HistogramArray<T> {

    private final T[] data;

    public static void main(String[] args) {
        String[] data = {"Accountance", "Human Resources", "Accountance", "Accountance", "Academia", "Human Resources"};

        HistogramArray h = new HistogramArray(data);
        Map<String, Integer> hData = h.getHistogram();

        for (String key : hData.keySet()) {
            System.out.println(key + "==>" + hData.get(key));
        }
    }

    public HistogramArray(T[] data) {
        this.data = data;
    }

    public T[] getData() {
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
