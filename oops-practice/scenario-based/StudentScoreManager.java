import java.util.Scanner;

public class StudentScoreManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.print("Enter the number of students: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) break;
            } else {
                scanner.next();
            }
            System.out.println("Please enter a valid positive integer.");
        }

        double[] scores = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    double val = scanner.nextDouble();
                    if (val >= 0 && val <= 100) {
                        scores[i] = val;
                        sum += val;
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("Invalid input. Enter a numeric score between 0 and 100.");
            }
        }

        double average = sum / n;
        double highest = scores[0];
        double lowest = scores[0];

        for (double score : scores) {
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        System.out.println("\n--- Performance Summary ---");
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score:  " + lowest);

        System.out.println("\nScores Above Average:");
        for (double score : scores) {
            if (score > average) {
                System.out.println("-> " + score);
            }
        }
        
        scanner.close();
    }
}