import java.util.Scanner;

public class UpperCase {
    public static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Check if character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // ASCII conversion
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
        String inputText = sc.nextLine();
        String manualUpperCase = convertToUpperCase(inputText);
        String builtInUpperCase = inputText.toUpperCase();
        boolean result = compareStrings(manualUpperCase, builtInUpperCase);

        // Displaying results
        System.out.println("\nManual Uppercase  : " + manualUpperCase);
        System.out.println("Built-in Uppercase: " + builtInUpperCase);
        System.out.println("Are both equal?   : " + result);
    }
}
