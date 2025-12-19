import java.util.*;

public class FactorialUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        if(number >= 0){
            int fact = 1;
            int i = 1;
            while(i <= number){
                fact = fact * i;
                i++;
            }
            System.out.println("The factorial of " + number + " is " + fact);
        }
        else{
            System.out.println("Please enter a positive number");
        }
    }
}
