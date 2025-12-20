import java.util.*;

public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the 5 numbers: ");

        int[] numbers = new int[5];
        for(int i=0; i<numbers.length; i++){
            numbers[i] = sc.nextInt();
        }
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] > 0){
                if(numbers[i] % 2 == 0){
                    System.out.println("Number is even");
                }else{
                    System.out.println("Number is odd");
                }
            }
            else if(numbers[i] < 0){
                System.out.println("Negative");
            }
            else{
                System.out.println("Zero");
            }
        }

        System.out.println("Comparision of First and Last Elements: ");
        if(numbers[0] == numbers[numbers.length-1]){
            System.out.println("Both Are Equal");
        }
        else if(numbers[0] > numbers[numbers.length-1]){
            System.out.println("First Element is greater");
        }
        else{
            System.out.println("First Element is smaller");
        }
    }
}
