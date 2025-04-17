import java.util.*;

public class RemoveDuplicates {
    static List<Integer> removeDuplicates(List<Integer> input) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (Integer num : input) {
            if (!seen.contains(num)) {
                result.add(num);
                seen.add(num);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(input);

        System.out.println("List After Removing Duplicates: " + result);
    }
}
