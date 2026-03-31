import java.util.Scanner;

public class UniqueFrequencyAnalyzer {
    public static char[] findUniqueCharacters(String str) {
        int n = str.length();
        char[] temp = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = str.charAt(i);
            boolean isDuplicate = false;
            
            // Nested loop to check if character appeared previously
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                temp[uniqueCount++] = current;
            }
        }

        // Create a precisely sized array for unique characters
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = temp[i];
        }
        return uniqueChars;
    }

    public static String[][] getFrequencyTable(String str) {
        // Step 1: ASCII frequency array
        int[] freqMap = new int[256];
        for (int i = 0; i < str.length(); i++) {
            freqMap[str.charAt(i)]++;
        }

        // Step 2: Get unique characters
        char[] uniqueChars = findUniqueCharacters(str);

        // Step 3: Store in 2D array [Unique Character][Frequency]
        String[][] resultTable = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            resultTable[i][0] = String.valueOf(uniqueChars[i]);
            resultTable[i][1] = String.valueOf(freqMap[uniqueChars[i]]);
        }

        return resultTable;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        if (input.isEmpty()) {
            System.out.println("String is empty.");
        } else {
            String[][] table = getFrequencyTable(input);

            System.out.println("\n--- Frequency Results ---");
            System.out.printf("%-10s | %-10s\n", "Character", "Frequency");
            System.out.println("---------------------------");
            for (String[] row : table) {
                // Formatting for spaces to make them visible in output
                String displayChar = row[0].equals(" ") ? "[Space]" : row[0];
                System.out.printf("%-10s | %-10s\n", displayChar, row[1]);
            }
        }
        sc.close();
    }
}
