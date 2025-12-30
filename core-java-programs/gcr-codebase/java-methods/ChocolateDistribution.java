import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findNumberOfChocolates(int numberOfChocolates, int numberOfChildren) {
        int[] result = new int[2];

        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than 0");
            return result;
        }

        result[0] = numberOfChocolates / numberOfChildren; // chocolates per child
        result[1] = numberOfChocolates % numberOfChildren; // remaining chocolates

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = sc.nextInt();

        int[] result = findNumberOfChocolates(numberOfChocolates, numberOfChildren);

        System.out.println("Each child gets: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);

        sc.close();
    }
}
