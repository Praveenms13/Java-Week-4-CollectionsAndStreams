public class CreditCardValidator {
    public static void main(String[] args) {
        String cardNumber = "4111111111111111";
        if (isValidCreditCard(cardNumber)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }
}
