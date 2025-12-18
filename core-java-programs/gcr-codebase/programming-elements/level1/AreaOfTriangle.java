import java.util.*;
public class TriangleArea{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double base = sc.nextDouble();
		double height = sc.nextDouble();

		double areaInSquareInches = (base*height)/2;
		double areaInSquareCm = areaInSquareInches * 6.4516;
		System.out.println("The area of a trinagle in square cm is " + (areaInSquareCm) + " while area in square inches is " + (areaInSquareInches));
	}
}
