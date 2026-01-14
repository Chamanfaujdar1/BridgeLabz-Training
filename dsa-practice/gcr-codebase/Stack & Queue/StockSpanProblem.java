import java.util.*;
public class StockSpanProblem {
    public static int[] calculateSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && prices[stack.peek()] < prices[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                span[i] = i+1;
            }
            else{
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return span;
    }

    public static void main(String[] args){
        int[] prices = {90, 70, 100, 65, 50};
        int[] result = calculateSpan(prices);

        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Span: " + Arrays.toString(result));
    }
}
