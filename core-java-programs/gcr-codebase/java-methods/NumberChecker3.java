import java.util.Scanner;

public class NumberChecker3 {
    public static int countDigits(int number) {
        int count = 0;
        int temp = number;

        while (temp != 0) {
            count++;
            temp /= 10;
        }
        return count;
    }
    public static int[] storeDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];

        int temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }
    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(int[] digits) {
        int[] reversed = reverseArray(digits);
        return compareArrays(digits, reversed);
    }
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Count of digits: " + countDigits(number));

        System.out.print("Digits array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        int[] reversedDigits = reverseArray(digits);
        System.out.print("Reversed digits array: ");
        for (int d : reversedDigits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Are original and reversed arrays equal? "
                + compareArrays(digits, reversedDigits));

        System.out.println("Is Palindrome Number? " + isPalindrome(digits));
        System.out.println("Is Duck Number? " + isDuckNumber(digits));

        scanner.close();
    }
}
