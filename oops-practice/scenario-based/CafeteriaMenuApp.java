import java.util.*;

public class CafeteriaMenuApp {

    public static void displayMenu(String[] items) {
        System.out.println("\n--- Cafeteria Menu ---");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " : " + items[i]);
        }
    }

    public static String getItemByIndex(String[] items, int index) {
        if (index < 0 || index >= items.length) {
            return "Invalid selection!";
        }
        return items[index];
    }

    public static void main(String[] args) {

        String[] menuItems = {
            "Veg Sandwich",
            "Cheese Burger",
            "Pasta",
            "Pizza Slice",
            "French Fries",
            "Samosa",
            "Veg Roll",
            "Cold Coffee",
            "Tea",
            "Chocolate Muffin"
        };

        Scanner scanner = new Scanner(System.in);

        displayMenu(menuItems);
        System.out.print("\nEnter item index to order: ");
        int choice = scanner.nextInt();

        String selectedItem = getItemByIndex(menuItems, choice);
        System.out.println("You selected: " + selectedItem);

        scanner.close();
    }
}
