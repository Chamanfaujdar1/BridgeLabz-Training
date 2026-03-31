package gcr_codebase.Exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter first number: ");
			int num1 = sc.nextInt();
			System.out.print("Enter second number: ");
			int num2 = sc.nextInt();
			int result = num1/num2;
			System.out.println(result);
		}
		catch(ArithmeticException e) {
			System.out.println("ArithmeticException: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Enter only numeric values: " + e.getMessage());
		}
		
		sc.close();
	}

}
