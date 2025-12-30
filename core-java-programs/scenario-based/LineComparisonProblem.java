import java.util.Scanner;

public class LineComparisonProblem {
    // UC 1: length Calculation using Cartesian coordinates
    public static Double lengthCalculator(String lineName) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates for " + lineName + " (x1, y1, x2, y2): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        // Formula: sqrt((x2-x1)^2 + (y2-y1)^2)
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // UC 2: Checking equality using the Java equals method
    public static void equalityCheck(Double l1, Double l2) {
        if (l1.equals(l2)) {
            System.out.println("Both lines are equal in length.");
        } else {
            System.out.println("Both lines are not equal in length.");
        }
    }

    // UC 3: Comparison of two lines using the Java compareTo method 
    public static void lineComparison(Double l1, Double l2) {
        int answer = l1.compareTo(l2);
        if (answer == 0) {
            System.out.println("First line is equal to second line.");
        } else if (answer > 0) {
            System.out.println("First line is greater than the second line.");
        } else {
            System.out.println("First line is smaller than the second line.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");

        Double length1 = lengthCalculator("Line 1");
        Double length2 = lengthCalculator("Line 2");

        equalityCheck(length1, length2);
        lineComparison(length1, length2);
    }
}