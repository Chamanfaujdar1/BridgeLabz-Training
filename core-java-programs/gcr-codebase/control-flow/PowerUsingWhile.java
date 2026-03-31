import java.util.Scanner;

public class PowerUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();

        if(number <= 0 || power < 0){
            System.out.println("enter positive integer");
            return;
        }
        int result = 1;
        int counter = 1;

        while(counter < power){
            result = result * number;
            counter++;
        }

        System.out.println(result);
    }
}
