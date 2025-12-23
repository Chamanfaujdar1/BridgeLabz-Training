import java.util.Scanner;

public class FirstUniqueChar {
    public static char findFirstNonRepeating(String str) {
        // Create an array to store frequency of 256 ASCII characters
        int[] frequency = new int[256];

        // First loop: Fill the frequency array
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            frequency[ch]++; 
        }

        // Second loop: Find the first character with a frequency of 1
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        // Return a null-equivalent character if no unique character exists
        return '\0';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = findFirstNonRepeating(input);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}
