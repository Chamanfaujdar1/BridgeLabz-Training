public class VotingTest {
    public static void main(String[]args){
        VotingSystem vs = new VotingSystem();

        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Alice");
        vs.castVote("Carol");
        vs.castVote("Bob");
        vs.castVote("Alice");

        System.out.println("Votes Stored (HashMap)");
        System.out.println(vs.getVoteCount());

        System.out.println("\nVote Order (LinkedHashMap)");
        System.out.println(vs.getVoteOrder());

        System.out.println("\nResults Sorted (TreeMap)");
        System.out.println(vs.getSortedResultsByCandidateName());
    }
}
