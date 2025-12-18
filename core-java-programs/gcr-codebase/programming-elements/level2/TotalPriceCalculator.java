import java.util.Scanner;

public class TotalPriceCalculator {
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		double unitPrice = sc.nextDouble();
		double quantity = sc.nextDouble();

		System.out.println("The total purchase price is INR " + (unitPrice*quantity) + " if the quantity " +(quantity)+ " and unit price is INR " + (unitPrice));
	}
}
