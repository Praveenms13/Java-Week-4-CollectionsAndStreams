import java.util.*;
import java.util.stream.*;

public class SumOfSquares {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8);

        int sumOfSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);
    }
}
