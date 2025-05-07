import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isFraudulent() {
        return isFraudulent;
    }
}

class FraudSummary {
    String policyNumber;
    int fraudCount;
    double totalFraudAmount;

    public FraudSummary(String policyNumber, int fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return String.format("FraudSummary{policyNumber='%s', fraudCount=%d, totalFraudAmount=%.2f}",
                policyNumber, fraudCount, totalFraudAmount);
    }
}

public class FraudDetector {

    public static List<FraudSummary> detectFraud(List<Transaction> transactions) {
        Map<String, List<Transaction>> grouped = transactions.stream()
                .filter(t -> t.isFraudulent() && t.getAmount() > 10000)
                .collect(Collectors.groupingBy(Transaction::getPolicyNumber));

        List<FraudSummary> summaries = grouped.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Transaction> frauds = entry.getValue();
                    int count = frauds.size();
                    double total = frauds.stream().mapToDouble(Transaction::getAmount).sum();
                    return new FraudSummary(policy, count, total);
                })
                .filter(summary -> summary.fraudCount > 5 || summary.totalFraudAmount > 50000)
                .collect(Collectors.toList());

        return summaries;
    }

    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P100", 15000, "2024-01-01", true),
                new Transaction("T2", "P100", 18000, "2024-01-02", true),
                new Transaction("T3", "P100", 12000, "2024-01-03", true),
                new Transaction("T4", "P100", 11000, "2024-01-04", true),
                new Transaction("T5", "P100", 13000, "2024-01-05", true),
                new Transaction("T6", "P100", 16000, "2024-01-06", true),
                new Transaction("T7", "P101", 60000, "2024-01-07", true),
                new Transaction("T8", "P102", 9000, "2024-01-08", true),
                new Transaction("T9", "P103", 12000, "2024-01-09", false)
        );

        List<FraudSummary> alerts = detectFraud(transactions);

        System.out.println("Fraud Alerts:");
        alerts.forEach(System.out::println);
    }
}
