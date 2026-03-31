import java.util.Scanner;

public class MultiplesBelowHundred {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num <= 0 || num >= 100){
            System.out.println("Enter a positive number less than 100");
            return;
        }

        for(int i=100; i>=1; i--){
            if(i % num == 0){
                System.out.println(i);
            }
        }
    }
}
