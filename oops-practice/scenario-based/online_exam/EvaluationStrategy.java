package online_exam;

public interface EvaluationStrategy {
    int evaluate(String[] correct, String[] ans);
}