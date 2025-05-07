import java.util.function.Function;

public class CircleAreaCalculator {
    public static void main(String[] args) {
        Function<Double, Double> calculateArea = radius -> Math.PI * radius * radius;
        double radius = 5.0;
        double area = calculateArea.apply(radius);
        System.out.println("The area of the circle with radius " + radius + " is: " + area);
    }
}
