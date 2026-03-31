import java.util.*;

public class CoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double GST_RATE = 0.05;
        while(true){
            System.out.println("Enter the coffee type (Espresso/Latte/Cappuccino/Americano):");
            System.out.println("Type exit to stop");
            String coffeeType = sc.nextLine();

            if(coffeeType.equals("exit")){
                System.out.println("Thank you for visiting our cafe! 🙏");
                break;
            }

            System.out.println("Please enter the quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            double pricePerCup;

            switch(coffeeType){
                case "Espresso":
                    pricePerCup = 150;
                    break;

                case "Latte":
                    pricePerCup = 180;
                    break;

                case "Cappuccino":
                    pricePerCup = 220;
                    break;
                    
                case "Americano":
                    pricePerCup = 120;
                    break;

                default:
                    System.out.println("Please enter the valid coffee type.");
                    continue;
            }

            double totalAmount = pricePerCup * quantity;
            double gstAmount = totalAmount * GST_RATE;
            double finalBill = totalAmount + gstAmount;

            System.out.println("Coffee Type: " + coffeeType + ", Quantity: " + quantity + ", Total Bill: ₹" + totalAmount + ", GST Amount: ₹" + gstAmount + ", Final Bill: ₹" + finalBill);
        }
    }
}
