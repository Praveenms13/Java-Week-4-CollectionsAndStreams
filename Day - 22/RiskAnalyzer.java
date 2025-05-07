import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }

    public String getHolderId() {
        return holderId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPolicyType() {
        return policyType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    public RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }

    @Override
    public String toString() {
        return String.format("RiskAssessment{holderId='%s', name='%s', riskScore=%.2f}", holderId, name, riskScore);
    }

    public double getRiskScore() {
        return riskScore;
    }
}

public class RiskAnalyzer {

    public static Map<String, List<RiskAssessment>> assessRisk(List<PolicyHolder> holders) {
        List<RiskAssessment> assessments = holders.stream()
                .filter(ph -> ph.getPolicyType().equalsIgnoreCase("Life") && ph.getAge() > 60)
                .map(ph -> new RiskAssessment(ph.getHolderId(), ph.getName(), ph.getPremiumAmount() / ph.getAge()))
                .sorted(Comparator.comparingDouble(RiskAssessment::getRiskScore).reversed())
                .collect(Collectors.toList());

        return assessments.stream()
                .collect(Collectors.groupingBy(
                        ra -> ra.getRiskScore() > 0.5 ? "High Risk" : "Low Risk"
                ));
    }

    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H1", "Alice", 65, "Life", 400.0),
                new PolicyHolder("H2", "Bob", 70, "Life", 200.0),
                new PolicyHolder("H3", "Charlie", 62, "Health", 300.0),
                new PolicyHolder("H4", "David", 75, "Life", 600.0),
                new PolicyHolder("H5", "Eve", 80, "Life", 300.0)
        );

        Map<String, List<RiskAssessment>> categorized = assessRisk(holders);

        categorized.forEach((category, list) -> {
            System.out.println(category + ":");
            list.forEach(System.out::println);
            System.out.println();
        });
    }
}
