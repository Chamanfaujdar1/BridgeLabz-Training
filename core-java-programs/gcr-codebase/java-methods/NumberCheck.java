import java.util.Scanner;

public class NumberCheck {
    public static int numberChecker(int number){
        if(number < 0){
            return -1;
        }
        else if(number > 0){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number: ");
        int number = sc.nextInt();

        int ans = numberChecker(number);
        System.out.println("Number is: " + ans);
    }
}
