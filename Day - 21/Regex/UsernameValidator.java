import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        if (username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$")) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}
