import java.util.Scanner;

public class VowelsConsonanats2 {
    public static String checkCharType(char ch) {
        if (ch >= 65 && ch <= 90) {
            ch = (char) (ch + 32);
        }

        if (ch >= 97 && ch <= 122) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    public static String[][] getCharacterDetails(String str) {
        String[][] details = new String[str.length()][2];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            details[i][0] = String.valueOf(ch);
            details[i][1] = checkCharType(ch);
        }

        return details;
    }

    public static void displayTable(String[][] data) {
        System.out.println("\n---------------------------");
        System.out.printf("%-12s | %-12s\n", "Character", "Type");
        System.out.println("---------------------------");
        
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-12s | %-12s\n", data[i][0], data[i][1]);
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String[][] results = getCharacterDetails(input);
        displayTable(results);

        scanner.close();
    }
}
