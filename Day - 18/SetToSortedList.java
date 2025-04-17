import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> input = new LinkedHashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Original List: " + input);

        List<Integer> sortedList = new ArrayList<>(input);
        Collections.sort(sortedList);

        System.out.println("Sorted List: " + sortedList);

    }

}
