import java.util.*;

@SuppressWarnings("FieldMayBeFinal")
class VotingSystem {
    private HashMap<String, Integer> voteMap = new HashMap<>();
    private LinkedHashMap<String, Integer> voteOrderMap = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteOrderMap.getOrDefault(candidate, 0) + 1);
    }

    public void displayVotesInOrder() {
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    public void displayVotesSorted() {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}

public class VotingManagementSystem {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");

        System.out.println("Votes in order of casting:");
        votingSystem.displayVotesInOrder();

        System.out.println("\nVotes sorted by candidate name:");
        votingSystem.displayVotesSorted();
    }
}
