@FunctionalInterface
interface SquareCalculator {
    int square(int number);
    default void printResult(int number) {
        int result = square(number);
        System.out.println("The square of " + number + " is: " + result);
    }
}

public class CustomFunctionalInterfaceExample {
    public static void main(String[] args) {
        SquareCalculator calculator = (number) -> number * number;
        calculator.printResult(4);
    }
}
