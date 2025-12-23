import java.util.Random;
import java.util.Scanner;

public class StudentGradeManager {
    public static int[][] generatePCMScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        Random rand = new Random();
        for (int i = 0; i < studentCount; i++) {
            scores[i][0] = rand.nextInt(90) + 10; // Physics
            scores[i][1] = rand.nextInt(90) + 10; // Chemistry
            scores[i][2] = rand.nextInt(90) + 10; // Math
        }
        return scores;
    }

    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            metrics[i][0] = total;
            metrics[i][1] = Math.round(average * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    public static String[][] calculateGrades(double[][] metrics) {
        String[][] grades = new String[metrics.length][2];
        for (int i = 0; i < metrics.length; i++) {
            double pct = metrics[i][2];
            if (pct >= 80) {
                grades[i][0] = "A";
                grades[i][1] = "(Level 4, above agency-normalized standards)";
            } else if (pct >= 70) {
                grades[i][0] = "B";
                grades[i][1] = "(Level 3, at agency-normalized standards)";
            } else if (pct >= 60) {
                grades[i][0] = "C";
                grades[i][1] = "(Level 2, below, but approaching standards)";
            } else if (pct >= 50) {
                grades[i][0] = "D";
                grades[i][1] = "(Level 1, well below standards)";
            } else if (pct >= 40) {
                grades[i][0] = "E";
                grades[i][1] = "(Level 1-, too below standards)";
            } else {
                grades[i][0] = "R";
                grades[i][1] = "(Remedial standards)";
            }
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] metrics, String[][] grades) {
        System.out.println("\n" + "=".repeat(105));
        System.out.printf("%-5s | %-3s | %-3s | %-3s | %-7s | %-7s | %-7s | %-5s | %-40s\n", 
                          "ID", "Phy", "Che", "Mat", "Total", "Avg", "Pct%", "Grd", "Remarks");
        System.out.println("-".repeat(105));

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-5d | %-3d | %-3d | %-3d | %-7.0f | %-7.2f | %-7.2f | %-5s | %-40s\n",
                (i + 1), (int)scores[i][0], (int)scores[i][1], (int)scores[i][2], 
                metrics[i][0], metrics[i][1], metrics[i][2], grades[i][0], grades[i][1]);
        }
        System.out.println("=".repeat(105));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[][] studentScores = generatePCMScores(n);
        double[][] studentMetrics = calculateMetrics(studentScores);
        String[][] studentGrades = calculateGrades(studentMetrics);

        displayScorecard(studentScores, studentMetrics, studentGrades);
        sc.close();
    }
}
