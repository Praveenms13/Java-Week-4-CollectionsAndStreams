import java.util.*;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> input = new LinkedList<>();
        for (int i = 0; i < 50; i += 10) {
            input.add(i + 10);
        }
        System.out.println("Original Queue: " + input);

        reverseQueue(input);

        System.out.println("Reversed Queue: " + input);

    }
}