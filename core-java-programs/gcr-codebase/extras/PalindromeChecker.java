import java.util.Scanner;

public class PalindromeChecker {
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }
    public static boolean isPalindrome(String text) {
        text = text.toLowerCase().replace(" ", "");

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void displayResult(String text, boolean result) {
        if (result) {
            System.out.println("\"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + text + "\" is NOT a Palindrome.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = getInput(sc);
        boolean result = isPalindrome(input);
        displayResult(input, result);

        sc.close();
    }
}
