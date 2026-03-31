package gcr_codebase.Exceptions;

import java.util.Scanner;

public class FinallyBlockExecution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.print("Enter first number: ");
			int num1 = sc.nextInt();
			
			System.out.print("Enter second number: ");
			int num2 = sc.nextInt();
			
			int division = num1/num2;
			System.out.println("Division Result: " + division);
		}
		catch(ArithmeticException e){
			System.out.println("Arithmetic Exception Occured: " + e.getMessage());
		}
		finally {
			System.out.println("Operation completed");
		}
		sc.close();
	}

}
