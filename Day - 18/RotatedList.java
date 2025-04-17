import java.util.*;

public class RotatedList {
    static List<Integer> rotated(List<Integer> input, int position) {
        int n = input.size();
        List<Integer> rotated = new ArrayList<>();

        position = position % n;

        for (int i = position; i < n; i++) {
            rotated.add(input.get(i));
        }
        for (int i = 0; i < position; i++) {
            rotated.add(input.get(i));
        }
        return rotated;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        List<Integer> result = rotated(input, rotateBy);

        System.out.println("The Rotated Array: \n" + result);

    }
}
