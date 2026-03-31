import java.util.Scanner;

public class NestedFrequencyCounter {
    public static String[] findFrequency(String text) {
        // Convert the string to a char array
        char[] charArray = text.toCharArray();
        // Array to store the frequency of each character
        int[] freqArray = new int[charArray.length];

        // Nested Loop to find frequency
        for (int i = 0; i < charArray.length; i++) {
            // Initialize frequency of each character to 1
            freqArray[i] = 1;

            // Only process if character is not '0' (already counted)
            if (charArray[i] != '0') {
                for (int j = i + 1; j < charArray.length; j++) {
                    if (charArray[i] == charArray[j]) {
                        // Increment frequency and mark duplicate as '0'
                        freqArray[i]++;
                        charArray[j] = '0';
                    }
                }
            }
        }

        // Count how many unique characters (not '0') to size the result array
        int uniqueCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                uniqueCount++;
            }
        }

        // Create a 1D String array to store characters and frequencies
        String[] result = new String[uniqueCount];
        int k = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != '0') {
                result[k] = charArray[i] + " -> " + freqArray[i];
                k++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (input.isEmpty()) {
            System.out.println("The input string is empty.");
        } else {
            // Call the user-defined method
            String[] frequencyList = findFrequency(input);

            // Display the results
            System.out.println("\n--- Character Frequencies ---");
            for (String entry : frequencyList) {
                System.out.println(entry);
            }
        }

        sc.close();
    }
}
