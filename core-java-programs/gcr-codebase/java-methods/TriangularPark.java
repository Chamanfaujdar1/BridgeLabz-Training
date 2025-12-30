import java.util.Scanner;

public class TriangularPark {
    public static double noOfRounds(double side1, double side2, double side3, int distance){
        return (distance/(side1+side2+side3));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of side 1: ");
        double side1 = sc.nextDouble();
        System.out.print("Enter the length of side 1: ");
        double side2 = sc.nextDouble();
        System.out.print("Enter the length of side 1: ");
        double side3 = sc.nextDouble();
        int distance = 5000;

        double rounds = noOfRounds(side1, side2, side3, distance);
        System.out.println("No of rounds user needs to do complete 5km run: " + rounds);
    }
}
