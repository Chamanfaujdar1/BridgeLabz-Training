import java.util.Scanner;

public class QuotientAndReminder {
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int[] ans = new int[2];
        int remainder = number % divisor;
        int quotient = number/divisor;

        ans[0] = remainder;
        ans[1] = quotient;

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number = sc.nextInt();
        System.out.print("Enter the second number: ");
        int divisor = sc.nextInt();

        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("Remainder: " + result[0]);
        System.out.print("Quotient: " + result[1]);

    }
}
