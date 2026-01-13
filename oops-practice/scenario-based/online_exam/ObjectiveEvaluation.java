package online_exam;

public class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(String[] correct, String[] ans) {
        int score = 0;
        for (int i = 0; i < correct.length; i++)
            if (correct[i].equalsIgnoreCase(ans[i]))
                score++;
        return score;
    }
}