import java.time.LocalDate;
import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyHolderName='" + policyHolderName + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}

@SuppressWarnings("FieldMayBeFinal")
class PolicyManager {
    private HashMap<String, Policy> policyHashMap = new HashMap<>();
    private LinkedHashMap<String, Policy> policyLinkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> policyTreeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyHashMap.put(policy.getPolicyNumber(), policy);
        policyLinkedHashMap.put(policy.getPolicyNumber(), policy);
        policyTreeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyHashMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        List<Policy> expiringPolicies = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : policyTreeMap.subMap(today, true, next30Days, true)
                .entrySet()) {
            expiringPolicies.addAll(entry.getValue());
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolderName(String holderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyHashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(holderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policyTreeMap.headMap(today, false).clear();
        Iterator<Map.Entry<String, Policy>> hashMapIterator = policyHashMap.entrySet().iterator();
        while (hashMapIterator.hasNext()) {
            Map.Entry<String, Policy> entry = hashMapIterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                hashMapIterator.remove();
            }
        }
        Iterator<Map.Entry<String, Policy>> linkedHashMapIterator = policyLinkedHashMap.entrySet().iterator();
        while (linkedHashMapIterator.hasNext()) {
            Map.Entry<String, Policy> entry = linkedHashMapIterator.next();
            if (entry.getValue().getExpiryDate().isBefore(today)) {
                linkedHashMapIterator.remove();
            }
        }
    }

    public void printAllPolicies() {
        for (Policy policy : policyHashMap.values()) {
            System.out.println(policy);
        }
    }
}

public class InsuranceManagementSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P001", "John Doe", LocalDate.now().plusDays(10));
        Policy p2 = new Policy("P002", "Jane Smith", LocalDate.now().plusDays(40));
        Policy p3 = new Policy("P003", "John Doe", LocalDate.now().minusDays(5));
        Policy p4 = new Policy("P004", "Alice Johnson", LocalDate.now().plusDays(25));

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        System.out.println("Retrieve Policy by Number (P001):");
        System.out.println(manager.getPolicyByNumber("P001"));

        System.out.println("\nPolicies expiring in next 30 days:");
        for (Policy p : manager.getPoliciesExpiringInNext30Days()) {
            System.out.println(p);
        }

        System.out.println("\nPolicies for John Doe:");
        for (Policy p : manager.getPoliciesByHolderName("John Doe")) {
            System.out.println(p);
        }

        System.out.println("\nRemoving expired policies...");
        manager.removeExpiredPolicies();

        System.out.println("\nPolicies after removing expired ones:");
        manager.printAllPolicies();
    }
}
