import java.util.*;
import java.util.stream.*;

public class OptionalHandling {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

        Optional<Integer> maxValue = numbers.stream()
                .max(Integer::compareTo);

        System.out.println("Maximum value: " + maxValue.orElseGet(() -> {
            System.out.println("The list is empty.");
            return null;
        }));

        List<Integer> emptyList = new ArrayList<>();
        Optional<Integer> maxValueEmpty = emptyList.stream()
                .max(Integer::compareTo);

        System.out.println("Maximum value for empty list: " + maxValueEmpty.orElseGet(() -> {
            System.out.println("The list is empty.");
            return null;
        }));
    }
}
