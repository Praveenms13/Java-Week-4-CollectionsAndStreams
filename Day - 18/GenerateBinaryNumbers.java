import java.util.*;

public class GenerateBinaryNumbers {
    static List<String> BinaryNumbers(int N) {
        List<String> binaryNumbers = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        for (int i = 0; i < N; i++) {
            String current = queue.remove();
            binaryNumbers.add(current);

            queue.add(current + "0");
            queue.add(current + "1");
        }
        return binaryNumbers;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> result = BinaryNumbers(N);
        System.out.println(result);
    }
}
