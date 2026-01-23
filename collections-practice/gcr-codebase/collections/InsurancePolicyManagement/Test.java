public class Test {
    public static void main(String[] args){
        PolicyManager manager = new PolicyManager();

        Policy p1 = new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000);
        Policy p2 = new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 3000);
        Policy p3 = new Policy("P103", "Carol", LocalDate.now().plusDays(25), "Home", 4500);
        Policy p4 = new Policy("P101", "Alice Duplicate", LocalDate.now().plusDays(90), "Health", 6000);

        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);

        System.out.println("All Unique Policies (HashSet)");
        System.out.println(manager.getAllUniquePoliciesUsingHashSet());

        System.out.println("\nAll Policies (Insertion Order - LinkedHashSet)");
        System.out.println(manager.getAllUniquePoliciesUsingLinkedHashSet());

        System.out.println("\nAll Policies Sorted By Expiry (TreeSet)");
        System.out.println(manager.getAllPoliciesSortedByExpiry());

        System.out.println("\nPolicies Expiring Soon (30 days)");
        System.out.println(manager.getPoliciesExpiringSoon(30));

        System.out.println("\nPolicies with Coverage Type = Health");
        System.out.println(manager.getPoliciesByCoverageType("Health"));

        List<Policy> allInput = Arrays.asList(p1, p2, p3, p4);
        System.out.println("\nDuplicate Policies by Policy Number (from input list)");
        System.out.println(manager.findDuplicatePoliciesByPolicyNumber(allInput));

        PerformanceTest.runComparison(50000);
    }
}
