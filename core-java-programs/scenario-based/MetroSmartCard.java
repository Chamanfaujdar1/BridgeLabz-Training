import java.util.*;
public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double balance = 100.0;
        char choice;

        System.out.println("Welcome to Delhi Metro Smart Card System One of the best metro service in world!");
        System.out.println("Initial Balance: ₹" + balance);

        do{
            System.out.println("Enter distance traveled (in km): ");
            double distance = sc.nextDouble();

            double fare = (distance <= 5) ? 10 : 20;

            if(balance >= fare){
                balance -= fare;
                System.out.println("Fare Charged: ₹" + fare);
                System.out.println("Remaining Balance: ₹" + balance);
            }
            else{
                System.out.println("❌ Insufficient balance. Please recharge");
                break;
            }

            System.out.println("Do you want to travel again? (Y/N): ");
            choice = sc.next().charAt(0);
        }
        while(choice == 'Y' || choice == 'y');

        System.out.println("Journey ended.");
        System.out.println("Final Balance: ₹" + balance);
    }
}
