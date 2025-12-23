import java.util.Scanner;

public class StringTrimmer {
    public static int[] getTrimBounds(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean customEquals(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string with leading and trailing spaces:");
        String input = scanner.nextLine();

        int[] bounds = getTrimBounds(input);
        
        String manualTrimmed = customSubstring(input, bounds[0], bounds[1]);

        String builtInTrimmed = input.trim();

        boolean areEqual = customEquals(manualTrimmed, builtInTrimmed);

        System.out.println("\n--- Results ---");
        System.out.println("Original: [" + input + "]");
        System.out.println("Manual Trim: [" + manualTrimmed + "]");
        System.out.println("Built-in Trim: [" + builtInTrimmed + "]");
        System.out.println("Strings Match: " + areEqual);

        scanner.close();
    }
}
