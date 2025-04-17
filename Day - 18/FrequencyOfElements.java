import java.util.*;

public class FrequencyOfElements {
    static HashMap<String, Integer> findFrequency(List<String> input) {
        HashMap<String, Integer> frequencyMap = new HashMap<>();

        for (String item : input) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }
        return frequencyMap;

    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        HashMap<String, Integer> result = findFrequency(input);
        // System.out.println(result);

        List<String> keys = new ArrayList<>(result.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            System.out.println(key + " : " + result.get(key));
        }

    }
}
