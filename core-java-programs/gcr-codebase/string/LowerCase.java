import java.util.Scanner;

public class LowerCase {
    public static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // ASCII conversion
            }
            result += ch;
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking complete text input
        System.out.print("Enter complete text: ");
        String inputText = sc.nextLine();

        // Using user-defined method
        String manualLowerCase = convertToLowerCase(inputText);

        // Using built-in method
        String builtInLowerCase = inputText.toLowerCase();

        // Comparing both strings
        boolean result = compareStrings(manualLowerCase, builtInLowerCase);

        // Displaying results
        System.out.println("\nManual Lowercase  : " + manualLowerCase);
        System.out.println("Built-in Lowercase: " + builtInLowerCase);
        System.out.println("Are both equal?   : " + result);
    }
}
