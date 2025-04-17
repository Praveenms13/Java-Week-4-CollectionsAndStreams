import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType,
            double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + ", Name: " + policyholderName + ", Expiry Date: " + expiryDate
                + ", Coverage: " + coverageType + ", Premium: " + premiumAmount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Policy policy = (Policy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
}

public class InsurancePolicyManagementSystem {

    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(Policy::getExpiryDate));

    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public void retrieveAllPolicies() {
        System.out.println("All Unique Policies:");
        System.out.println("HashSet: " + hashSet);
        System.out.println("LinkedHashSet: " + linkedHashSet);
        System.out.println("TreeSet (sorted by Expiry Date): " + treeSet);
    }

    public void retrieveExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate in30Days = today.plusDays(30);

        List<Policy> expiringSoon = treeSet.stream()
                .filter(policy -> !policy.getExpiryDate().isAfter(in30Days))
                .collect(Collectors.toList());

        System.out.println("\nPolicies Expiring Soon (within 30 days): " + expiringSoon);
    }

    public void retrieveByCoverageType(String coverageType) {
        List<Policy> filteredPolicies = treeSet.stream()
                .filter(policy -> policy.getCoverageType().equalsIgnoreCase(coverageType))
                .collect(Collectors.toList());

        System.out.println("\nPolicies with Coverage Type " + coverageType + ": " + filteredPolicies);
    }

    public void findDuplicates() {
        Set<String> policyNumbers = new HashSet<>();
        Set<Policy> duplicates = new HashSet<>();

        for (Policy policy : hashSet) {
            if (!policyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }

        System.out.println("\nDuplicate Policies (if any): " + duplicates);
    }

    public void comparePerformance() {
        int numberOfPolicies = 10000;
        Random random = new Random();
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < numberOfPolicies; i++) {
            String policyNumber = "POLICY" + i;
            Policy policy = new Policy(policyNumber, "Policyholder " + i, LocalDate.now().plusDays(random.nextInt(365)),
                    "Health", 1000.0);
            addPolicy(policy);
        }
        endTime = System.nanoTime();
        System.out.println("\nAdd Operation Time (ns) - HashSet: " + (endTime - startTime));

        startTime = System.nanoTime();
        hashSet.removeIf(policy -> policy.getPolicyNumber().equals("POLICY5000"));
        endTime = System.nanoTime();
        System.out.println("Remove Operation Time (ns) - HashSet: " + (endTime - startTime));

        startTime = System.nanoTime();
        hashSet.contains(new Policy("POLICY5000", "", LocalDate.now(), "", 0.0));
        endTime = System.nanoTime();
        System.out.println("Search Operation Time (ns) - HashSet: " + (endTime - startTime));
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.of(2023, 7, 15), "Health", 1200.0));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.of(2023, 5, 22), "Auto", 1500.0));
        system.addPolicy(new Policy("P003", "Charlie", LocalDate.of(2023, 6, 30), "Home", 800.0));

        system.retrieveAllPolicies();
        system.retrieveExpiringSoon();
        system.retrieveByCoverageType("Health");
        system.findDuplicates();
        system.comparePerformance();
    }
}
