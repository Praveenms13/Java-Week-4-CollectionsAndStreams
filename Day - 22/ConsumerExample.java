import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Consumer<String> printUppercase = s -> System.out.println(s.toUpperCase());
        words.forEach(printUppercase);
    }
}
