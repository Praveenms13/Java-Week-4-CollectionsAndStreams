import java.util.function.BiFunction;

public class StringConcatenation {
    public static void main(String[] args) {
        BiFunction<String, String, String> concatenateWithSpace = (str1, str2) -> str1 + " " + str2;

        String str1 = "Hello";
        String str2 = "World";
        String result = concatenateWithSpace.apply(str1, str2);

        System.out.println("Concatenated result: " + result);
    }
}
