import java.util.List;

public class StockPriceLogger {
    public static void main(String[] args){
        List<Double> stockPrices = List.of(
            1523.50,
            1530.75,
            1518.40,
            1542.10,
            1550.00
        );

        System.out.println("Live Stock Price Updates:");
        stockPrices.stream()
                   .forEach(price ->
                       System.out.println("Stock Price Update: ₹" + price)
                   );
    }
}
