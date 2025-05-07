import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateComposition {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("running", "walk", "swimming", "run", "walking", "jumping", "play");

        Predicate<String> lengthGreaterThan5 = s -> s.length() > 5;
        Predicate<String> containsSubstring = s -> s.contains("ing");

        Predicate<String> combinedPredicate = lengthGreaterThan5.and(containsSubstring);

        List<String> filtered = words.stream()
                .filter(combinedPredicate)
                .collect(Collectors.toList());

        System.out.println("Filtered List: " + filtered);
    }
}
