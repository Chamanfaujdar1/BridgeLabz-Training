public class ProfitLoss{
	public static void main(String[] args){
		int costPrice = 129;
		int sellingPrice = 191;

		System.out.print("The Cost Price is INR " + costPrice + " and Selling Price is INR " + sellingPrice + "\n" + "The Profit is INR " + (sellingPrice-costPrice) + " and the Profit Percentage is " + ((sellingPrice - costPrice)*100)/costPrice);
	}
}
