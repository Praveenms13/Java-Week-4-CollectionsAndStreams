import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class InsurancePolicy {
    String policyNumber;
    String holderName;
    double premiumAmount;

    public InsurancePolicy(String policyNumber, String holderName, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Holder Name: " + holderName + ", Premium Amount: " + premiumAmount;
    }
}

public class InsuranceApp {
    public static void main(String[] args) {
        List<InsurancePolicy> policies = Arrays.asList(
                new InsurancePolicy("P001", "Alice Smith", 1500),
                new InsurancePolicy("P002", "Bob Brown", 1100),
                new InsurancePolicy("P003", "Charlie Johnson", 2500),
                new InsurancePolicy("P004", "David Lee", 800),
                new InsurancePolicy("P005", "Eve Adams", 2200),
                new InsurancePolicy("P006", "Frank Wright", 1800)
        );

        List<InsurancePolicy> filteredPolicies = policies.stream()
                .filter(p -> p.premiumAmount > 1200)
                .collect(Collectors.toList());
        filteredPolicies.forEach(System.out::println);

        List<InsurancePolicy> sortedPoliciesByName = policies.stream()
                .sorted(Comparator.comparing(p -> p.holderName))
                .collect(Collectors.toList());
        sortedPoliciesByName.forEach(System.out::println);

        double totalPremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .sum();
        System.out.println("Total Premium: " + totalPremium);

        policies.forEach(System.out::println);

        List<InsurancePolicy> filteredByRange = policies.stream()
                .filter(p -> p.premiumAmount >= 1000 && p.premiumAmount <= 2000)
                .collect(Collectors.toList());
        filteredByRange.forEach(System.out::println);

        Optional<InsurancePolicy> highestPremiumPolicy = policies.stream()
                .max(Comparator.comparingDouble(p -> p.premiumAmount));
        highestPremiumPolicy.ifPresent(policy -> System.out.println(policy));

        Map<Character, List<InsurancePolicy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.holderName.charAt(0)));
        groupedByInitial.forEach((initial, policyList) -> {
            System.out.println(initial + ": " + policyList);
        });

        double averagePremium = policies.stream()
                .mapToDouble(p -> p.premiumAmount)
                .average()
                .orElse(0);
        System.out.println("Average Premium: " + averagePremium);

        List<InsurancePolicy> sortedByPremium = policies.stream()
                .sorted(Comparator.comparingDouble(p -> p.premiumAmount))
                .collect(Collectors.toList());
        sortedByPremium.forEach(System.out::println);

        boolean anyPolicyExceeds2000 = policies.stream()
                .anyMatch(p -> p.premiumAmount > 2000);
        System.out.println("Any policy exceeds 2000? " + anyPolicyExceeds2000);

        Map<String, Long> premiumRangeCounts = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.premiumAmount <= 1000) return "$0-$1,000";
                    else if (p.premiumAmount <= 2000) return "$1,001-$2,000";
                    else return ">$2,000";
                }, Collectors.counting()));
        premiumRangeCounts.forEach((range, count) -> System.out.println(range + ": " + count));

        List<String> uniqueHolderNames = policies.stream()
                .map(p -> p.holderName)
                .distinct()
                .collect(Collectors.toList());
        uniqueHolderNames.forEach(System.out::println);

        String substring = "Smith";
        List<InsurancePolicy> policiesWithSubstring = policies.stream()
                .filter(p -> p.holderName.contains(substring))
                .collect(Collectors.toList());
        policiesWithSubstring.forEach(System.out::println);

        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(p -> p.policyNumber, p -> p.premiumAmount));
        policyMap.forEach((policyNumber, premiumAmount) -> System.out.println(policyNumber + ": " + premiumAmount));

        String text = "apple banana apple orange banana apple orange banana";
        List<String> words = Arrays.asList(text.split("\\s+"));
        Map<String, Long> wordFrequency = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        Optional<Map.Entry<String, Long>> secondMostFrequentWord = wordFrequency.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .skip(1)
                .findFirst();
        secondMostFrequentWord.ifPresent(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
