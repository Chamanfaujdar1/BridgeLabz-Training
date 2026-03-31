import java.util.Scanner;

public class LargestAndSecondLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        int index = 0;

        while (number != 0 && index < maxDigit) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        // Variables to store largest and second largest
        int largest = 0;
        int secondLargest = 0;

        // -------- FIND LARGEST & SECOND LARGEST --------
        for (int i = 0; i < index; i++) {

            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } 
            else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        System.out.println("\nLargest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);

        sc.close();
    }
}
