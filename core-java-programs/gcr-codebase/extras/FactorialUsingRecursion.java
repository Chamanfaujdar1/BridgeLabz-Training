import java.util.Scanner;

public class FactorialUsingRecursion {
    public static int getInput(Scanner sc) {
        System.out.print("Enter a non-negative number: ");
        return sc.nextInt();
    }
    public static long factorial(int number) {

        if (number < 0) {
            return -1;
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }
    public static void displayResult(int number, long result) {

        if (result == -1) {
            System.out.println("Please enter a positive number.");
        } else {
            System.out.println("Factorial of " + number + " is: " + result);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = getInput(sc);
        long result = factorial(number);
        displayResult(number, result);

        sc.close();
    }
}
