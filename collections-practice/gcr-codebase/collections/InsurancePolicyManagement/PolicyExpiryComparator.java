import java.util.Comparator;

public class PolicyExpiryComparator {
    public int compare(Policy a, Policy b) {
        int cmp = a.getExpiryDate().compareTo(b.getExpiryDate());
        if (cmp != 0) return cmp;
        return a.getPolicyNumber().compareTo(b.getPolicyNumber());
    }
}
