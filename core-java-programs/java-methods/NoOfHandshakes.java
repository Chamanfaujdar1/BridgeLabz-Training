import java.util.Scanner;

public class NoOfHandshakes {
    public static int possibleHandShakesCalculator(int numberOfStudents){
        return (numberOfStudents * (numberOfStudents-1))/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        int possibleHandShakes = possibleHandShakesCalculator(numberOfStudents);
        System.out.println("Number of possible handshakes are: " + possibleHandShakes);
    }
}
