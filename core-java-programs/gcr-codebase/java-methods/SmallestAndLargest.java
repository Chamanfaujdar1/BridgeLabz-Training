import java.util.Scanner;

public class SmallestAndLargest {
    public static int[] findSmallestAndLargest(int number1, int number2, int number3){
        int[] ans = new int[2];
        int largest = number1;
        int smallest = number1;
        if(number2 < smallest) smallest = number2;
        if(number2 > largest) largest = number2;

        if(number3 < smallest) smallest = number3;
        if(number3 > largest) largest = number3;

        ans[0] = smallest;
        ans[1] = largest;

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = sc.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = sc.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3);
        System.out.println("Smallest number is: " + result[0]);
        System.out.println("Largest number is: " + result[1]);


    }
}
