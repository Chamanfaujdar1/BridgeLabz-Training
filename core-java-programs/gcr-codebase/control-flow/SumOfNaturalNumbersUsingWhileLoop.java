import java.util.*;

public class SumOfNaturalNumbersUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n >= 1){
            int sum = 0;
            int i = 1;
            while(i <= n){
                sum += i;
                i++;
            }

            int formulaSum = n * (n + 1) / 2;
            System.out.println("Sum using while loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);

            if(sum == formulaSum){
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("There is a discrepancy between the two methods.");
            }
        }
        else{
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
