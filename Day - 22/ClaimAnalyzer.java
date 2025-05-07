import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public String getStatus() {
        return status;
    }
}

class PolicyClaimStats {
    String policyNumber;
    double totalClaimAmount;
    double averageClaimAmount;

    public PolicyClaimStats(String policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }

    @Override
    public String toString() {
        return String.format("PolicyClaimStats{policyNumber='%s', total=%.2f, average=%.2f}",
                policyNumber, totalClaimAmount, averageClaimAmount);
    }

    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }
}

public class ClaimAnalyzer {

    public static List<PolicyClaimStats> analyzeClaims(List<Claim> claims) {
        Map<String, List<Claim>> groupedClaims = claims.stream()
                .filter(c -> c.getStatus().equalsIgnoreCase("Approved") && c.getClaimAmount() > 5000)
                .collect(Collectors.groupingBy(Claim::getPolicyNumber));

        List<PolicyClaimStats> statsList = groupedClaims.entrySet().stream()
                .map(entry -> {
                    String policy = entry.getKey();
                    List<Claim> policyClaims = entry.getValue();
                    double total = policyClaims.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = total / policyClaims.size();
                    return new PolicyClaimStats(policy, total, average);
                })
                .sorted(Comparator.comparingDouble(PolicyClaimStats::getTotalClaimAmount).reversed())
                .limit(3)
                .collect(Collectors.toList());

        return statsList;
    }

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P100", 6000, "2024-01-01", "Approved"),
                new Claim("C2", "P101", 12000, "2024-02-15", "Approved"),
                new Claim("C3", "P100", 7000, "2024-03-10", "Approved"),
                new Claim("C4", "P102", 3000, "2024-04-01", "Approved"),
                new Claim("C5", "P103", 15000, "2024-01-20", "Rejected"),
                new Claim("C6", "P101", 9000, "2024-05-05", "Approved"),
                new Claim("C7", "P104", 11000, "2024-03-15", "Approved"),
                new Claim("C8", "P104", 2000, "2024-04-20", "Approved")
        );

        List<PolicyClaimStats> topPolicies = analyzeClaims(claims);

        System.out.println("Top 3 Policies by Total Claim Amount:");
        topPolicies.forEach(System.out::println);
    }
}
