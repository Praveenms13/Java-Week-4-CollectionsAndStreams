public class FindNthElement {
    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static String findNthFromEnd(Node head, int N) {
        if (head == null || N <= 0) {
            return "Invalid Input";
        }
        Node first = head;
        Node second = head;

        for (int i = 0; i < N; i++) {
            if (first == null) {
                return "N is greater than the length of the list";
            }
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second.data;

    }

    public static void main(String[] args) {
        Node head = new Node("A");
        head.next = new Node("B");
        head.next.next = new Node("C");
        head.next.next.next = new Node("D");
        head.next.next.next.next = new Node("E");

        int N = 2;
        String result = findNthFromEnd(head, N);

        System.out.println("The " + N + " Element from the End is: " + result);
    }
}
