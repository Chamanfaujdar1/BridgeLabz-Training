class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayItem() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    public void addItem(int qty) {
        this.quantity += qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    public void removeItem(int qty) {
        if (qty <= this.quantity) {
            this.quantity -= qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Error: Not enough items in cart to remove.");
        }
    }

    public void displayTotal() {
        double total = price * quantity;
        System.out.printf("Total cost: $%.2f%n", total);
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Laptop", 999.99, 1);
        cart.displayItem();
        cart.addItem(2);
        cart.removeItem(1);
        cart.displayTotal();
    }
}