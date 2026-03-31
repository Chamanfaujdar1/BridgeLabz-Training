public class Factoriall{
	public static long calculateFactorial(int num){
		if(num < 0){
			System.out.println("Factorial doesn't exist");
		}
		if(num <= 1){
			return 1;
		}

		return num * calculateFactorial(num - 1);
	}

	public static void main(String[] args){
		int num = 5;
		System.out.println(calculateFactorial(num));
	}
}
