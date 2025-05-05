import java.util.regex.*;

public class SSNValidator {
    public static void main(String[] args) {
        String ssn = "123-45-6789"; // Example input
        if (ssn.matches("^\\d{3}-\\d{2}-\\d{4}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
