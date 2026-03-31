import java.util.Random;
import java.util.Scanner;

public class StudentVotingSystem {
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // Generates a random 2-digit number (10 to 99)
            ages[i] = random.nextInt(90) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] status = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            status[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                status[i][1] = "false (Invalid Age)";
            } else if (ages[i] >= 18) {
                status[i][1] = "true";
            } else {
                status[i][1] = "false";
            }
        }
        return status;
    }

    public static void displayResults(String[][] data) {
        System.out.println("\n--- Student Voting Eligibility ---");
        System.out.printf("%-10s | %-15s\n", "Age", "Can Vote");
        System.out.println("-------------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-10s | %-15s\n", data[i][0], data[i][1]);
        }
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of students (e.g., 10): ");
        int n = scanner.nextInt();

        // 1. Generate ages
        int[] studentAges = generateAges(n);

        // 2. Process eligibility into 2D array
        String[][] eligibilityTable = checkVotingEligibility(studentAges);

        // 3. Display in tabular format
        displayResults(eligibilityTable);

        scanner.close();
    }
}
