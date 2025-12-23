import java.util.Scanner;

public class CharacterFrequency {
    public static String[][] getFrequencyDetails(String str) {
        // Step 1: Create an array to store frequency of 256 ASCII characters
        int[] freqMap = new int[256];

        // Step 2: Loop through the text to find the frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freqMap[ch]++;
        }

        // Step 3: Count unique characters to determine the size of the 2D array
        int uniqueCount = 0;
        for (int count : freqMap) {
            if (count > 0) {
                uniqueCount++;
            }
        }

        // Step 4: Create a 2D array to store characters and frequencies
        String[][] results = new String[uniqueCount][2];
        int index = 0;

        // Step 5: Loop through text again to store values in original order
        // and avoid duplicates in the final table
        boolean[] processed = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!processed[ch]) {
                results[index][0] = "'" + ch + "'";
                results[index][1] = String.valueOf(freqMap[ch]);
                processed[ch] = true;
                index++;
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            System.out.println("The string is empty.");
        } else {
            String[][] frequencyTable = getFrequencyDetails(input);

            // Display results in a tabular format
            System.out.println("\n--- Character Frequency ---");
            System.out.printf("%-12s | %-10s\n", "Character", "Frequency");
            System.out.println("----------------------------");
            for (String[] row : frequencyTable) {
                System.out.printf("%-12s | %-10s\n", row[0], row[1]);
            }
        }

        scanner.close();
    }
}
