import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generatePCMScores(int students) {
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = percentage;
        }
        return results;
    }

    public static String getGrade(double percentage) {
        if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else if (percentage >= 40) return "E";
        else return "R";
    }

    public static void displayScoreCard(int[][] scores, double[][] results) {

        System.out.println("--------------------------------------------");
        System.out.println("Stu\tPhysics\tChem\tMath\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("--------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    (i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t" +
                    scores[i][2] + "\t" +
                    (int) results[i][0] + "\t" +
                    results[i][1] + "\t" +
                    results[i][2] + "\t\t" +
                    getGrade(results[i][2])
            );
        }

        System.out.println("---------------------------");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        int[][] scores = generatePCMScores(students);
        double[][] results = calculateResults(scores);

        displayScoreCard(scores, results);

        scanner.close();
    }
}
