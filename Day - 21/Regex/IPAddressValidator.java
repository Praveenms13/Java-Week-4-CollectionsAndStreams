import java.util.regex.*;

public class IPAddressValidator {
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        if (ip.matches("^([0-9]{1,3}\\.){3}[0-9]{1,3}$") && isValidIP(ip)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean isValidIP(String ip) {
        String[] parts = ip.split("\\.");
        for (String part : parts) {
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) {
                return false;
            }
        }
        return true;
    }
}
