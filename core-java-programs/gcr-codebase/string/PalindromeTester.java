import java.util.Scanner;

public class PalindromeTester {
    public static boolean isPalindromeIterative(String text) {
        int start = 0; //
        int end = text.length() - 1; //

        while (start < end) { //
            if (text.charAt(start) != text.charAt(end)) { //
                return false; //
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) { //
            return true; //
        }
        if (text.charAt(start) != text.charAt(end)) { //
            return false; //
        }
        // Call recursively with start incremented and end decremented
        return isPalindromeRecursive(text, start + 1, end - 1); //
    }

    // Logic 3: Using character arrays and reversal
    public static char[] reverseString(String text) {
        char[] reversed = new char[text.length()];
        int j = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed[j++] = text.charAt(i); //
        }
        return reversed; //
    }

    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray(); //
        char[] reversed = reverseString(text); //

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) { //
                return false; //
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to check: ");
        String input = sc.nextLine();
        
        // Clean input for better checking (optional, but standard for palindromes)
        String cleanInput = input.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Logic 1 (Iterative): " + isPalindromeIterative(cleanInput));
        System.out.println("Logic 2 (Recursive): " + isPalindromeRecursive(cleanInput, 0, cleanInput.length() - 1));
        System.out.println("Logic 3 (Array/Reverse): " + isPalindromeArray(cleanInput));

        sc.close();
    }
}
