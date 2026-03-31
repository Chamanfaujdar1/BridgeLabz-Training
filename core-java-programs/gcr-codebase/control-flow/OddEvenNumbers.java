import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if(num >= 1){
            for(int i=1; i<= num; i++){
                if(i % 2 == 0){
                    System.out.println(i + " is Even");
                }
                else{
                    System.out.println(i + " is Odd");
                }
            }
        }
        else{
            System.out.println("Please enter a positive integer.");
        }
    }
}
