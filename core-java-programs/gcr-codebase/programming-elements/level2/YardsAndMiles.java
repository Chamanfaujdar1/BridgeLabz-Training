import java.util.Scanner;

public class YardsAndMiles {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int distanceInFeet = sc.nextInt();
		int distanceInYards = distanceInFeet/3;
		int distanceInMiles = distanceInYards/1760;

		System.out.println("Your height in feet is " + (distanceInFeet) + " while in Yards is "+(distanceInYards) + " and in Miles is " + (distanceInMiles));
	}
}
