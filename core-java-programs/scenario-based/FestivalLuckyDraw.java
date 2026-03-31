import java.util.Scanner;

public class FestivalLuckyDraw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your lucky number: ");
            int number = sc.nextInt();

            // Invalid input check
            if (number <= 0) {
                System.out.println("Invalid number! Please enter a positive number.");
                continue;
            }

            // Gift condition
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎉 Congratulations! You won a gift!");
            } else {
                System.out.println("Better luck next time!");
            }

            // Continue or exit
            System.out.print("Is there another visitor? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\nLucky Draw Closed. Happy Diwali! 🪔");
        sc.close();
    }
}
