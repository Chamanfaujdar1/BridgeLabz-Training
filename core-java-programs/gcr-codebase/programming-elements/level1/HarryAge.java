import java.util.*;
public class AgeFinder{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int BirthYear = sc.nextInt();

		int CurrentYear = 2024;

		System.out.println("Harry's age in 2024 is " + (CurrentYear - BirthYear));
	}
}
