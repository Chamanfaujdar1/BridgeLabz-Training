package online_exam;

public class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(String[] correct, String[] ans) {
        return ans.length * 2;
    }
}