import java.util.*;

public class SymmetricDifference {
    static Set<Integer> SymmetricDiff(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> union = new TreeSet<>(set1);
        union.addAll(set2);

        Set<Integer> interSection = new TreeSet<>(set1);
        interSection.retainAll(set2);

        union.removeAll(interSection);
        return union;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(30, 50, 60));

        Set<Integer> result = SymmetricDiff(set1, set2);

        System.out.println("The Symmetric Difference is: " + result);

    }
}
