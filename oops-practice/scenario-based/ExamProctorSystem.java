import java.util.*;

class ExamProctorSystem {

    private Stack<Integer> navigationStack;

    private HashMap<Integer, String> studentAnswers;

    private HashMap<Integer, String> correctAnswers;

    public ExamProctorSystem() {
        navigationStack = new Stack<>();
        studentAnswers = new HashMap<>();
        correctAnswers = new HashMap<>();
        loadCorrectAnswers();
    }

    private void loadCorrectAnswers() {
        correctAnswers.put(1, "A");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
        correctAnswers.put(4, "D");
        correctAnswers.put(5, "A");
    }

    public void visitQuestion(int questionID) {
        navigationStack.push(questionID);
        System.out.println("Visited Question: " + questionID);
    }

    public void answerQuestion(int questionID, String answer) {
        studentAnswers.put(questionID, answer.toUpperCase());
        System.out.println("Saved Answer for Question " + questionID + ": " + answer.toUpperCase());
    }

    public void showLastVisitedQuestion() {
        if (navigationStack.isEmpty()) {
            System.out.println("No questions visited yet.");
        } else {
            System.out.println("Last Visited Question: " + navigationStack.peek());
        }
    }

    public void goBack() {
        if (navigationStack.isEmpty()) {
            System.out.println("Navigation stack is empty. Cannot go back.");
            return;
        }

        int removed = navigationStack.pop();
        System.out.println("Went back from Question: " + removed);

        if (!navigationStack.isEmpty()) {
            System.out.println("Now at Question: " + navigationStack.peek());
        } else {
            System.out.println("No previous question available.");
        }
    }

    public int calculateScore() {
        int score = 0;

        for (Map.Entry<Integer, String> entry : correctAnswers.entrySet()) {
            int questionID = entry.getKey();
            String correct = entry.getValue();

            String studentAns = studentAnswers.getOrDefault(questionID, ""); // empty if not answered

            if (studentAns.equals(correct)) {
                score++;
            }
        }

        return score;
    }

    public void submitExam() {
        System.out.println("\n Exam Submitted Successfully!");
        System.out.println(" Checking Answers...");

        int score = calculateScore();
        System.out.println(" Final Score: " + score + " / " + correctAnswers.size());
    }
}

public class ExamProctorMain {
    public static void main(String[] args) {

        ExamProctorSystem system = new ExamProctorSystem();

        system.visitQuestion(1);
        system.answerQuestion(1, "A");

        system.visitQuestion(2);
        system.answerQuestion(2, "C"); 

        system.visitQuestion(3);
        system.answerQuestion(3, "C"); 

        system.visitQuestion(4);
        system.answerQuestion(4, "D"); 

        system.showLastVisitedQuestion();

        system.goBack();
        system.showLastVisitedQuestion();

        system.visitQuestion(5);
        system.answerQuestion(5, "A");

        system.submitExam();
    }
}
