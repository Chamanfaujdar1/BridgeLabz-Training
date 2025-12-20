import java.util.*;

public class MaximumNumbersUpToTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers= new double[10];
        double total = 0.0;

        int index = 0;
        while(true){
            System.out.print("Enter a number: ");
            double input = sc.nextDouble();
            if(input == 0 || input < 0){
                break;
            }
            if(index == 10){
                break;
            }

            numbers[index] = input;
            index++;
        }

        System.out.println("numbers entered: ");
        for(int i=0; i<index; i++){
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("Sum of all numbers: " + total);

    }
}
