package online_exam;

public class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String msg) {
        super(msg);
    }
}