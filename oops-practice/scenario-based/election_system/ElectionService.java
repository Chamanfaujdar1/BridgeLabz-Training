package election_system;

public interface ElectionService {
    void vote(Voter v, Candidate c) throws DuplicateVoteException;
}