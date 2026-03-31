import java.util.*;

public class SumOfNaturalNumbersUsingForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n >= 1){
            int sum = 0;
            for(int i=1; i<=n; i++){
                sum += i;
            }
            int formulaSum = n * (n+1)/2;
            System.out.println("Sum using for loop: " + sum);
            System.out.println("Sum using formula: " + formulaSum);

            if(sum == formulaSum){
                System.out.println("Both methods give the same result.");
            } else {
                System.out.println("Results are not same");
            }
        }
        else{
            System.out.println("The number " + n + " is not a natural number");
        }
    }
}
