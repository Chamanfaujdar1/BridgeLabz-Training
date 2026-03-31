import java.util.Scanner;

public class MultipleUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num <= 0 || num >= 100){
            System.out.println("enter positive number less than 100");
            return;
        }
        int counter = 100;
        while(counter >= 1){
            if(counter % num == 0){
                System.out.println(counter);
            }
            counter--;
        }
    }
}
