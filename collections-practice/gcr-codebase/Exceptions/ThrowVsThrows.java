package gcr_codebase.Exceptions;

//class IllegalArgumentException extends Exception{
//	public IllegalArgumentException(String message) {
//		super(message);
//	}
//}

public class ThrowVsThrows {
	public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
		if(amount < 0 || rate < 0) {
			throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
		}
		return (amount * rate * years)/100;
	}
	
	public static void main(String[] args) {
		try {
			double interest = calculateInterest(-4000, -5, 3);
			System.out.println("Simple Interest: " + interest);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

}
