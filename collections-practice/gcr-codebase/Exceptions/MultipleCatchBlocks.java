package gcr_codebase.Exceptions;
import java.util.*;

public class MultipleCatchBlocks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int[] arr = {7,4,9,10};
			
			System.out.print("Enter Index: ");
			int index = sc.nextInt();
			
			System.out.println("Element at index " + index + " " + arr[index]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
		}
		catch(NullPointerException e) {
			System.out.println("NullPointerException: " + e.getMessage());
		}
		sc.close();
	}

}
