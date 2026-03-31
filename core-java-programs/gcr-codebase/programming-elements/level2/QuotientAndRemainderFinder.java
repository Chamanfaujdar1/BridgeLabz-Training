import java.util.Scanner;

public class QuotientAndRemainderFinder {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double number1 = sc.nextDouble();
    double number2 = sc.nextDouble();

    double quotient = number1 / number2;
    double reaminder = number1%number2;

    System.out.println("The Quotient is " + (quotient) + " and Remainder is " + (reaminder) + " of two numbers " + (number1) + " and " + (number2));
    }
}
