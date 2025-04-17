import java.util.*;

public class ReverseList {
    public static List<Integer> reverseArrayList(List<Integer> list) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(i + 1);
        }
        return reversed;
    }

    public static List<Integer> reverseLinkedList(List<Integer> list) {
        List<Integer> reversed = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> arayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arayList.add(i + 1);
        }
        System.out.println("Original Array List: " + arayList);
        List<Integer> reverseList = reverseArrayList(arayList);
        System.out.println("Reversed Array List: " + reverseList);

        List<Integer> LinkList = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            LinkList.add(i + 1);
        }
        System.out.println("\nOriginal LinkedList: " + LinkList);
        List<Integer> reversedList = reverseLinkedList(LinkList);
        System.out.println("Reversed LinkedList:" + reversedList);

    }
}
