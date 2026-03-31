import java.util.List;

public class TransformingNamesForDisplay {
    public static void main(String[] args){
        List<String> customerNames = List.of(
            "rahul",
            "Amit",
            "neha",
            "suresh",
            "Priya"
        );

        List<String> formattedNames = customerNames.stream()

            .map(String::toUpperCase)

            .sorted()

            .toList();

        System.out.println("Customer Names (Uppercase & Sorted):");
        formattedNames.forEach(System.out::println);
    }
}
