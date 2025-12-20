import java.util.Scanner;
public class LeapYearUsingLogicalOperator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        if(year >= 1582 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            System.out.println("Year is a Leap Year");
        }
        else if(year < 1582){
            System.out.println("Please enter year after 1582");
        }
        else{
            System.out.println("Year is not a Leap Year");
        }
    }
}
