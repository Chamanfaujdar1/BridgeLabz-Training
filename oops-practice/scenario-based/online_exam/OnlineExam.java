package online_exam;

public class OnlineExam {

    String[] correct = { "A", "B", "C", "D" };
    String[] student = { "A", "B", "A", "D" };

    void submit(boolean expired) throws ExamTimeExpiredException {
        if (expired)
            throw new ExamTimeExpiredException("Exam time expired");
        EvaluationStrategy e = new ObjectiveEvaluation();
        System.out.println("Score: " + e.evaluate(correct, student));
    }

    public static void main(String[] args) {
        OnlineExam o = new OnlineExam();
        try {
            o.submit(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}