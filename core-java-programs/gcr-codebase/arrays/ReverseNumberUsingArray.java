import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;

        // -------- COUNT DIGITS --------
        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];

        // -------- STORE DIGITS --------
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] reverseDigits = new int[count];

        // -------- REVERSE ARRAY --------
        for (int i = 0; i < count; i++) {
            reverseDigits[i] = digits[count - 1 - i];
        }
        System.out.print("\nReversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverseDigits[i]);
        }
    }
}
