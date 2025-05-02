import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {5, 10, 15, 20, 25};

        try {
            System.out.print("Enter index to access: ");
            int index = scanner.nextInt();

            try {
                int value = array[index];
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                int result = value / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}

