import java.util.*;

public class UnionAndIntersection {
    static Set<Integer> Union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(set1);
        result.addAll(set2);
        return result;
    }

    static Set<Integer> Intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new TreeSet<>(set1);
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(10, 20, 30));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(40, 50, 60));

        Set<Integer> unionResult = Union(set1, set2);
        Set<Integer> intersectionResult = Intersection(set1, set2);

        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectionResult);
    }
}
