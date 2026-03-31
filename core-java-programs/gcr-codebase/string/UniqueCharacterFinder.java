import java.util.Scanner;

public class UniqueCharacterFinder {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    public static char[] getUniqueChars(String str) {
        int len = findLength(str);
        char[] tempArray = new char[len];
        int uniqueCount = 0;

        for (int i = 0; i < len; i++) {
            char currentChar = str.charAt(i);
            boolean isAlreadyPresent = false;

            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == currentChar) {
                    isAlreadyPresent = true;
                    break;
                }
            }

            if (!isAlreadyPresent) {
                tempArray[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] finalArray = new char[uniqueCount];
        for (int k = 0; k < uniqueCount; k++) {
            finalArray[k] = tempArray[k];
        }

        return finalArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char[] result = getUniqueChars(input);

        System.out.println("Length of string: " + findLength(input));
        System.out.print("Unique characters: ");
        for (char c : result) {
            System.out.print(c + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
