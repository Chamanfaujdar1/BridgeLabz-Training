import java.util.*;
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

public class StudentScoreAnalyzer {

    private static void validateScores(int[] scores)
            throws InvalidScoreException {

        for (int score : scores) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException(
                    "Invalid score detected: " + score +
                    " (Scores must be between 0 and 100)"
                );
            }
        }
    }

    public static double calculateAverage(int[] scores)
            throws InvalidScoreException {

        validateScores(scores);

        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }

    public static int findMax(int[] scores)
            throws InvalidScoreException {

        validateScores(scores);

        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }

    public static int findMin(int[] scores)
            throws InvalidScoreException {

        validateScores(scores);

        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        int[] scores = {78, 85, 92, 67, 88};

        try {
            System.out.println("Average Score : " +
                calculateAverage(scores));
            System.out.println("Highest Score : " +
                findMax(scores));
            System.out.println("Lowest Score  : " +
                findMin(scores));

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
