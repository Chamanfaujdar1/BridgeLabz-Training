import java.util.*;
public class SimpleInterest {
    public static double simpleInterestCalculator(double principal, double rate, double time){
        return (principal * rate * time)/100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the principal amount: ");
        double principal = sc.nextDouble();
        System.out.print("Enter the rate: ");
        double rate = sc.nextDouble();
        System.out.print("Enter the time: ");
        double time = sc.nextDouble();

        double simpleInterest = simpleInterestCalculator(principal, rate, time);
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal + " , Rate of interest " + rate + " and Time " + time);

        sc.close();
    }
}
