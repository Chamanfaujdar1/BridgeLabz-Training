import java.util.*;
import java.time.LocalDate;

public class PolicyManager {
    private final Set<Policy> hashSet = new HashSet<>();
    private final Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private final Set<Policy> treeSet = new TreeSet<>(new PolicyExpiryComparator());

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    public void removePolicy(Policy p) {
        hashSet.remove(p);
        linkedHashSet.remove(p);
        treeSet.remove(p);
    }

    public boolean containsPolicy(Policy p) {
        return hashSet.contains(p);
    }

    public Set<Policy> getAllUniquePoliciesUsingHashSet() {
        return new HashSet<>(hashSet);
    }

    public Set<Policy> getAllUniquePoliciesUsingLinkedHashSet() {
        return new LinkedHashSet<>(linkedHashSet);
    }

    public Set<Policy> getAllPoliciesSortedByExpiry() {
        return new TreeSet<>(treeSet);
    }

    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(days);

        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSet) {
            if (!p.getExpiryDate().isBefore(today) && !p.getExpiryDate().isAfter(limit)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Policy> getPoliciesByCoverageType(String type) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : hashSet) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Policy> findDuplicatePoliciesByPolicyNumber(List<Policy> policies) {
        Map<String, Integer> freq = new HashMap<>();
        for (Policy p : policies) {
            freq.put(p.getPolicyNumber(), freq.getOrDefault(p.getPolicyNumber(), 0) + 1);
        }

        List<Policy> duplicates = new ArrayList<>();
        for (Policy p : policies) {
            if (freq.get(p.getPolicyNumber()) > 1) {
                duplicates.add(p);
            }
        }
        return duplicates;
    }
}
