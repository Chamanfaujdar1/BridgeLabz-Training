import java.util.*;
public class HandShake{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int numberOfStudents = sc.nextInt();
		int noOfHandShake = (numberOfStudents * (numberOfStudents-1))/2;
		System.out.println("number of possible handshakes: " + (noOfHandShake));
	}
}
