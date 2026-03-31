package election_system;

public class Election implements ElectionService {

    public void vote(Voter v, Candidate c) throws DuplicateVoteException {
        if (v.voted)
            throw new DuplicateVoteException("Already voted");
        c.votes++;
        v.voted = true;
    }

    public static void main(String[] args) {
        Election e = new Election();
        Voter v = new Voter(1);
        Candidate c = new Candidate("Alex");
        try {
            e.vote(v, c);
            e.vote(v, c);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}