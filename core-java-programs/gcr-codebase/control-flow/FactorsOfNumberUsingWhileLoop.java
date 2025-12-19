import java.util.Scanner;

public class FactorsOfNumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int counter = 1;
        while(counter < num){
            if(num % counter == 0){
                System.out.println(counter);
            }
            counter++;
        }
    }
    
}
