import java.util.*;

public class InvertMap {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> inputMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : inputMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            if (invertedMap.containsKey(value)) {
                invertedMap.get(value).add(key);
            } else {
                List<K> list = new ArrayList<>();
                list.add(key);
                invertedMap.put(value, list);
            }
        }
        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 3);

        Map<Integer, List<String>> inverted = invertMap(input);
        System.out.println("Inverted Map: " + inverted);
    }
}
