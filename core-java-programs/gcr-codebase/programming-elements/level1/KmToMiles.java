import java.util.*;
public class KmToMiles{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double kiloMeters = sc.nextDouble();
		double miles = kiloMeters * 0.621371;
		System.out.println(miles);
	}
}
