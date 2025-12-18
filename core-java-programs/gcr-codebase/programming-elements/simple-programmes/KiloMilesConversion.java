import java.util.*;
public class Converter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double km = sc.nextDouble();
		System.out.println("The total miles is " + (km*1.6) + " mile for the given " + (km) + " km");
	}
}
