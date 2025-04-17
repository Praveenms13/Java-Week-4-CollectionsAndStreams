import java.util.*;

public class CompareSets {
    static boolean areSetsEqual(Set<Integer> set1, Set<Integer> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 0, 10));

        boolean result = areSetsEqual(set1, set2);

        System.out.println("Are The Sets Equal: " + result);
    }
}