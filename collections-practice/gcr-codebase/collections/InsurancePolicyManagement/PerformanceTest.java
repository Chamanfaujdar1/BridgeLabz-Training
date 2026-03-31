public class PerformanceTest {
    public static List<Policy> generatePolicies(int n){
        List<Policy> list = new ArrayList<>();
        LocalDate base = LocalDate.now().plusDays(1);

        for (int i = 1; i <= n; i++) {
            String policyNo = "P" + i;
            String name = "User" + i;
            LocalDate expiry = base.plusDays(i % 365);
            String coverage;

            if (i % 3 == 0) coverage = "Health";
            else if (i % 3 == 1) coverage = "Auto";
            else coverage = "Home";

            double premium = 1000 + (i % 500) * 10;
            list.add(new Policy(policyNo, name, expiry, coverage, premium));
        }

        return list;
    }

    public static void testSetPerformance(Set<Policy> set, List<Policy> policies){
        Policy searchPolicy = policies.get(policies.size() / 2);

        long startAdd = System.nanoTime();
        for (Policy p : policies) set.add(p);
        long endAdd = System.nanoTime();

        long startSearch = System.nanoTime();
        boolean found = set.contains(searchPolicy);
        long endSearch = System.nanoTime();

        long startRemove = System.nanoTime();
        for (int i = 0; i < policies.size() / 2; i++) {
            set.remove(policies.get(i));
        }
        long endRemove = System.nanoTime();

        System.out.println("Added: " + (endAdd - startAdd) + " ns");
        System.out.println("Searched: " + (endSearch - startSearch) + " ns | Found: " + found);
        System.out.println("Removed: " + (endRemove - startRemove) + " ns");
    }

    public static void runComparison(int n) {
        List<Policy> policies = generatePolicies(n);

        System.out.println("\nHashSet Performance");
        testSetPerformance(new HashSet<>(), policies);

        System.out.println("\nLinkedHashSet Performance");
        testSetPerformance(new LinkedHashSet<>(), policies);

        System.out.println("\nTreeSet Performance (Sorted by Expiry)");
        testSetPerformance(new TreeSet<>(new PolicyExpiryComparator()), policies);
    }
}
