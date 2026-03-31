import java.util.Scanner;

public class GCDAndLCMCalculator {
    public static int calculateGCD(int a, int b) {

        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
    public static int calculateLCM(int a, int b) {

        int gcd = calculateGCD(a, b);
        return Math.abs(a * b) / gcd;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        int gcd = calculateGCD(Math.abs(num1), Math.abs(num2));
        int lcm = calculateLCM(num1, num2);

        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
        System.out.println("LCM of " + num1 + " and " + num2 + " is: " + lcm);

        sc.close();
    }
}
