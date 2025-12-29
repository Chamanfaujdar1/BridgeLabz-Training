import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
    public static String getUserFeedback(Scanner sc) {
        System.out.print("Is the guess high, low, or correct? ");
        return sc.nextLine().toLowerCase();
    }
    public static int[] updateRange(String feedback, int guess, int low, int high) {
        if (feedback.equals("high")) {
            high = guess - 1;
        } else if (feedback.equals("low")) {
            low = guess + 1;
        }
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int low = 1;
        int high = 100;
        boolean isCorrect = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (!isCorrect && low <= high) {
            int guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);

            String feedback = getUserFeedback(sc);

            if (feedback.equals("correct")) {
                System.out.println("I guessed your number correctly.");
                isCorrect = true;
            } else if (feedback.equals("high") || feedback.equals("low")) {
                int[] range = updateRange(feedback, guess, low, high);
                low = range[0];
                high = range[1];
            } else {
                System.out.println("Invalid input. Please enter high, low, or correct.");
            }
        }

        sc.close();
    }
}
