class Order{
    private String customer;
    private double amount;

    public Order(String customer, double amount){
        this.customer = customer;
        this.amount = amount;
    }

    public String getCustomer() {
        return customer;
    }

    public double getAmount() {
        return amount;
    }
}

public class OrderRevenueSummary {
    public static void main(String[] args){
        List<Order> orders = List.of(
            new Order("Alice", 100.0),
            new Order("Bob", 150.0),
            new Order("Alice", 200.0),
            new Order("Charlie", 50.0),
            new Order("Bob", 100.0)
        );

        Map<String, Double> revenuePerCustomer = orders.stream()
        .collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::getAmount)));

        System.out.println(RevenuePerCustomer);
    }
}
