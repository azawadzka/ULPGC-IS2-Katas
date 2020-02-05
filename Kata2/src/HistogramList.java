import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistogramList<T> {

    private final List<T> data;

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>();
        data.add("Accountance");
        data.add("Human Resources");
        data.add("Accountance");
        data.add("Accountance");
        data.add("Academia");
        data.add("Human Resources");

        HistogramList h = new HistogramList(data);
        Map<String, Integer> hData = h.getHistogram();

        for (String key : hData.keySet()) {
            System.out.println(key + "==>" + hData.get(key));
        }
    }

    public HistogramList(List<T> data) {
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
