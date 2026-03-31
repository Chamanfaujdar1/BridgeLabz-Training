import java.util.*;

public class VotingSystem {
    private final HashMap<String, Integer> voteCount = new HashMap<>();
    private final LinkedHashMap<Integer, String> voteOrder = new LinkedHashMap<>();
    private int voteId = 1;

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.put(voteId, candidate);
        voteId++;
    }

    public HashMap<String, Integer> getVoteCount() {
        return new HashMap<>(voteCount);
    }

    public LinkedHashMap<Integer, String> getVoteOrder() {
        return new LinkedHashMap<>(voteOrder);
    }

    public TreeMap<String, Integer> getSortedResultsByCandidateName() {
        return new TreeMap<>(voteCount);
    }
}
