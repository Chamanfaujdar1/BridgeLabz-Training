public class Item {
    String itemCode;
    double itemPrice;
    String itemName;

    Item(String itemCode, double itemPrice, String itemName){
        this.itemCode = itemCode;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    void displayDetails(){
        System.out.println("itemCode: " + itemCode);
        System.out.println("itemPrice: " + itemPrice);
        System.out.println("itemName: " + itemName);
    }

    double calculateCost(int quantity){
        return this.itemPrice * quantity;
    }

    public static void main(String[] args){
        Item item1 = new Item("01AA", 500.0, "Water bottle");
        item1.displayDetails();
        Item item2 = new Item("01BB", 700.0, "Rice");
        item2.displayDetails();
        Item item3 = new Item("02AA", 400.0, "blackboard");
        item3.displayDetails();
    }
}
