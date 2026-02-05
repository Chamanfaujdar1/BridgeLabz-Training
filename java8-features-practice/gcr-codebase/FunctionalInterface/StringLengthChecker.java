import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args){
        Function<String, Integer> getLength = str -> str.length();

        String message = "Hello, My name is john. And John banega don";
        int maxLimit = 20;

        int length = getLength.apply(message);

        if(length > maxLimit){
            System.out.println("String exceeds maximum length of " + maxLimit + " characters.");
        }
        else{
            System.out.println("String is within the maximum limit.");
        }
     }
}
