import java.util.*;
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

class QuizProcessor {

    public static int calculateScore(String[] correct, String[] user)
            throws InvalidQuizSubmissionException {

        if (correct.length != user.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count mismatch. Quiz submission is invalid."
            );
        }

        int score = 0;

        for (int i = 0; i < correct.length; i++) {
            if (correct[i].equalsIgnoreCase(user[i])) {
                score++;
            }
        }

        return score;
    }

    public static String getGrade(int score, int totalQuestions) {
        double percentage = (score * 100.0) / totalQuestions;

        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "Fail";
    }
}

public class OnlineQuizPlatform {
    public static void main(String[] args){
        String[] correctAnswers = {
            "A", "C", "B", "D", "A"
        };

        String[][] userAnswers = {
            {"A", "C", "B", "D", "A"},
            {"A", "B", "B", "D", "C"},
            {"A", "C", "B"}
        };

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < userAnswers.length; i++) {
            try {
                int score = QuizProcessor.calculateScore(
                        correctAnswers, userAnswers[i]);

                scores.add(score);

                String grade = QuizProcessor.getGrade(
                        score, correctAnswers.length);

                System.out.println("User " + (i + 1));
                System.out.println("Score : " + score);
                System.out.println("Grade : " + grade);
                System.out.println("-------------------");

            }catch (InvalidQuizSubmissionException e) {
                System.out.println("User " + (i + 1) + " Error: "
                        + e.getMessage());
                System.out.println("-------------------");
            }
        }

        System.out.println("All Valid Scores: " + scores);
    }
}
