import java.util.*;
import java.util.stream.Collectors;

public class FilterStrings {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot", "Blueberry");

        List<String> filtered = words.stream()
                .filter(word -> !word.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
    }
}
