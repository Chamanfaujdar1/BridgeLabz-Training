import java.util.Scanner;

public class SumOfNNaturalNumbers {
    public static int sumCalculator(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        int ans = sumCalculator(n);
        System.out.println("Sum of " + n + " natural numbers is: " + ans);
    }
}
