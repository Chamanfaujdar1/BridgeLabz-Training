import java.time.LocalDate;
import java.util.List;

public class FilteringExpiringMemberships {

    static class GymMember {
        String name;
        LocalDate expiryDate;

        GymMember(String name, LocalDate expiryDate) {
            this.name = name;
            this.expiryDate = expiryDate;
        }

        @Override
        public String toString() {
            return name + " | Expiry Date: " + expiryDate;
        }
    }

    public static void main(String[] args){
        LocalDate today = LocalDate.now();

        List<GymMember> members = List.of(
            new GymMember("Amit", today.plusDays(10)),
            new GymMember("Neha", today.plusDays(40)),
            new GymMember("Rahul", today.plusDays(25)),
            new GymMember("Priya", today.minusDays(5)),
            new GymMember("Suresh", today.plusDays(30))
        );

        List<GymMember> expiringSoon = members.stream()

            .filter(member ->
                !member.expiryDate.isBefore(today) &&     
                !member.expiryDate.isAfter(today.plusDays(30))
            )

            .toList();

        System.out.println("Members with Membership Expiring in Next 30 Days:");
        expiringSoon.forEach(System.out::println);
    }
}
