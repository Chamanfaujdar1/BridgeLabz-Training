import java.util.*;
public class RectanglePerimeter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double length = sc.nextDouble();
		double breadth = sc.nextDouble();

		double perimeter = 2 * (length + breadth);
		System.out.println(perimeter);
	}
}
