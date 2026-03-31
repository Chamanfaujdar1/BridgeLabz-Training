import java.util.Scanner;

public class AnagramChecker {
    public static boolean isAnagram(String str1, String str2) {
        // 1. Check if the lengths of the two texts are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // 2. Create arrays to store the frequency of characters for both texts
        // Using 256 for the full extended ASCII set
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        // 3. Find the frequency of characters in the two texts using a loop
        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
            freq2[str2.charAt(i)]++;
        }

        // 4. Compare the frequency of characters in the two texts
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Anagram Checker ---");
        System.out.print("Enter first text: ");
        String text1 = sc.nextLine();
        System.out.print("Enter second text: ");
        String text2 = sc.nextLine();

        // Standardize input (optional: remove spaces and ignore case)
        String clean1 = text1.replaceAll("\\s", "").toLowerCase();
        String clean2 = text2.replaceAll("\\s", "").toLowerCase();

        boolean result = isAnagram(clean1, clean2);

        if (result) {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are Anagrams.");
        } else {
            System.out.println("\"" + text1 + "\" and \"" + text2 + "\" are NOT Anagrams.");
        }

        sc.close();
    }
}
