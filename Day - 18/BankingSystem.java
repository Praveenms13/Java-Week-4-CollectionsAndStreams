import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
class Bank {
    private HashMap<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalRequests = new LinkedList<>();

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalRequests.add(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalRequests.isEmpty()) {
            String accountNumber = withdrawalRequests.poll();
            double balance = accounts.get(accountNumber);
            if (balance >= amount) {
                accounts.put(accountNumber, balance - amount);
                System.out.println("Withdrawal of $" + amount + " successful for Account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for Account: " + accountNumber);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            for (String account : entry.getValue()) {
                System.out.println("Account: " + account + " -> Balance: $" + entry.getKey());
            }
        }
    }

    public void displayAllAccounts() {
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " -> Balance: $" + entry.getValue());
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("ACC1001", 5000);
        bank.createAccount("ACC1002", 3000);
        bank.createAccount("ACC1003", 7000);
        bank.createAccount("ACC1004", 2500);

        System.out.println("All Accounts:");
        bank.displayAllAccounts();

        bank.requestWithdrawal("ACC1001");
        bank.requestWithdrawal("ACC1004");
        bank.requestWithdrawal("ACC1002");

        System.out.println("\nProcessing Withdrawals of $2000:");
        bank.processWithdrawals(2000);

        System.out.println("\nAccounts sorted by Balance:");
        bank.displayAccountsSortedByBalance();
    }
}
