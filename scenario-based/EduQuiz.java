public class EduQuiz {
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        System.out.println("Quiz Feedback:\n");

        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }

        return score;
    }

    public static void main(String[] args) {

        String[] correctAnswers = {
                "A", "B", "C", "D", "A",
                "C", "B", "D", "A", "C"
        };

        String[] studentAnswers = {
                "a", "b", "c", "a", "A",
                "c", "B", "d", "b", "C"
        };

        int score = calculateScore(correctAnswers, studentAnswers);

        double percentage = (score / 10.0) * 100;

        System.out.println("\nFinal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");

        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
}
